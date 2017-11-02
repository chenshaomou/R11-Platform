package org.rainboweleven.platform.filter;

import org.rainboweleven.platform.controller.util.TokenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwt的过滤器，用来过滤一些需要登录的接口
 */

@Component
@Order(2)
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private Long jwtExpiration;
    @Value("${jwt.tokenHead}")
    private String jwtTokenHead;
    @Value("${jwt.header}")
    private String jwtHeader;
    @Value("${jwt.protected.url}")
    private String protectedUrl;
    @Autowired
    private TokenApi tokenApi;

    /**
     *
     * JWT 安全权限过滤
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //暂时不需要登录就可以访问
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        return;
/*
        //先判断该路径是否需要登录
        String url = httpServletRequest.getServletPath();
        String[] paths = url.split("/");
        if(paths.length > 1 ){
            String beginPath = paths[1];
            if (protectedUrl.equals(beginPath)){
                //是需要登录才能访问的
                String jwtHeaderValue = httpServletRequest.getHeader(jwtHeader);
                if (jwtHeaderValue == null) {
                    httpServletResponse.sendError(401,"请先登录");
                    return;
                }
                //取得token
                String token = jwtHeaderValue.substring(jwtTokenHead.length());
                if ("".equals(token) || token.length() == 0){
                    httpServletResponse.sendError(403,"登录信息异常");
                    return;
                }
                //判断token是否合法
                if(tokenApi.validateToken(token)){
                    //在这里加上 username 给后面的 controller 使用
                    httpServletRequest.setAttribute("username",tokenApi.getUsernameFromToken(token));
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                }else{
                    httpServletResponse.sendError(403,"请求非法或超时，请重新登录");
                    return;
                }
            }else{
                //不需要登录就可以访问
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        }else{
            //访问的是根目录 '/'
            httpServletResponse.sendError(404,"页面不存在");
        }
        */
    }

}
