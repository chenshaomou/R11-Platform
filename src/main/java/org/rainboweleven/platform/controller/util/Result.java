package org.rainboweleven.platform.controller.util;

import com.google.gson.Gson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Result {

    private static Gson gson=new Gson();

    private Long timestamp;
    private String clientip;
    private boolean result;
    private String error;
    private Object data;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Result() {
        this.timestamp = new Date().getTime();
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    /**
     * 在data中放入一个key-value string
     * @param key
     * @param value
     */
    public void putString(String key,String value){

        if(this.data == null){
            this.data = new HashMap<String,Object>();
        }

        if(this.data instanceof Map){
            Map _theData = (Map)this.data;
            _theData.put(key,value);
        }else{
            //抛出一个异常
            throw new dataTypeErrorException("你不能往一个非Map的结果集合进行putString操作");
        }
    }

    /**
     * 这个是一个运行时的异常，用来提示返回值是否正确赋值
     */
    public class dataTypeErrorException extends RuntimeException{

        public dataTypeErrorException(String message){
            super(message);
        }
    }
}
