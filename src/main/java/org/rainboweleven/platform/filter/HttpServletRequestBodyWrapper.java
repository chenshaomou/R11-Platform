package org.rainboweleven.platform.filter;

import com.google.common.io.ByteStreams;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写这个类的目的是为了：
 * 原来的request中的 inputstream 的字节读一次出来就没有了
 * 在做拦截的时候，如果读出来打印了，后面的controller就读不到了
 * 所以这里写个 requestwrapper 先讲流读出来，放在一个byte数组中先
 * 以后想什么时候读都可以随时读
 */
public class HttpServletRequestBodyWrapper extends HttpServletRequestWrapper{

    private final byte[] body;

    public HttpServletRequestBodyWrapper(HttpServletRequest request) throws IOException {
        super(request);
        body = ByteStreams.toByteArray(request.getInputStream());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bodyInputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bodyInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }
}
