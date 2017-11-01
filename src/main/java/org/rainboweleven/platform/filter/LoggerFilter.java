package org.rainboweleven.platform.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 接口日志记录过滤器
 * TODO:现在所有的请求都做了日志记录，其实应该是只对controller的请求做日志，也不要对文件型的请求做日志
 */
@Component
@Order(1)
public class LoggerFilter extends OncePerRequestFilter {

    private static final Logger logger =  LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        Date begin = new Date();
        HttpServletRequestBodyWrapper requestWrapper = new HttpServletRequestBodyWrapper(httpServletRequest);
        HttpServletBodyResponseWrapper responseWrapper =  new HttpServletBodyResponseWrapper(httpServletResponse);
        filterChain.doFilter(requestWrapper,responseWrapper);
        RequestLoggerObject rlo = new RequestLoggerObject(requestWrapper,responseWrapper);
        rlo.setTimeStamp(begin);
        logger.info(rlo.toString());
    }
}
