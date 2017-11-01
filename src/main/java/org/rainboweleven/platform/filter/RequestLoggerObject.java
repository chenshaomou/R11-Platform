package org.rainboweleven.platform.filter;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 这个类的作用是每次请求都会产生这样一个对象，然后会以日志记录的形式记录下来
 */
public class RequestLoggerObject {

    private static Gson gson=new Gson();
    /**
     *  TODO:SimpleDateFormat 非线程安全，在高并发的情况下可能有问题
     */
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String path;
    private String method;
    private String remoteIP;
    private Map<String,Object> headers = new HashMap<String, Object>();
    private Map<String,Object> parameters = new HashMap<String, Object>();;
    private String body = "";
    private String timeStamp;
    private Map<String,Object> responseHeaders = new HashMap<String, Object>();
    private int responseStatus;
    private String responseTime;
    private String responseBody;

    public RequestLoggerObject(){}

    public RequestLoggerObject(HttpServletRequestBodyWrapper request, HttpServletBodyResponseWrapper response){

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerKey =  headerNames.nextElement();
            String headerValue = request.getHeader(headerKey);
            this.headers.put(headerKey,headerValue);
        }
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        Enumeration<String> queryNames = request.getParameterNames();
        while (queryNames.hasMoreElements()){
            String queryKey = queryNames.nextElement();
            String queryValue = request.getParameter(queryKey);
            this.parameters.put(queryKey,queryValue);
        }
        this.remoteIP = String.format("%s:%s",request.getRemoteAddr(),request.getRemotePort());
        this.responseTime = sdf.format(new Date());
        try {
            StringBuffer bodySB = new StringBuffer();
            String line;
            BufferedReader br = request.getReader();
            while ((line = br.readLine()) != null){
                bodySB.append(line);
            }
            this.body = bodySB.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<String> responseHeaderNames = response.getHeaderNames().iterator();
        while (responseHeaderNames.hasNext()){
            String headerKey =  responseHeaderNames.next();
            String headerValue = response.getHeader(headerKey);
            this.responseHeaders.put(headerKey,headerValue);
        }
        this.responseStatus = response.getStatus();
        this.responseBody = response.getBody();
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = sdf.format(date);
    }

    public Map<String, Object> getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Map<String, Object> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public void setResponseTime(Date date) {
        this.responseTime = sdf.format(date);
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
}
