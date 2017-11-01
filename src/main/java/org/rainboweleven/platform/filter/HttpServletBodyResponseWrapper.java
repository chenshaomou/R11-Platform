package org.rainboweleven.platform.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * 这个是为了记录response返回值加的wrapper
 * 通过重写 getOutputStream 方法，在往outputstream缓存区写数据前，先将字符串用stringbuffer记录下来，最后输出到日志上
 * 该方法简单粗暴，并没经过大量的实际验证
 * TODO:寻找替代方案
 * TODO:大并发下测试可靠性，另外 StringBuffer 线程安全，但在一个request就是一个单独的线程，可以不需要线程安全
 */
public class HttpServletBodyResponseWrapper extends HttpServletResponseWrapper {

    private StringBuffer bodySB = new StringBuffer();

    public HttpServletBodyResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        final ServletOutputStream outputStream = super.getOutputStream();
        return new ServletOutputStream() {
            @Override
            public boolean isReady() {
                return false;
            }
            @Override
            public void setWriteListener(WriteListener writeListener) {

            }
            @Override
            public void write(int b) throws IOException {
                bodySB.append((char) b);
                outputStream.write(b);
            }
        };
    }

    public String getBody(){
        return bodySB.toString();
    }
}
