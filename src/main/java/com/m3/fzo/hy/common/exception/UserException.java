package com.m3.fzo.hy.common.exception;


public class UserException extends Exception {
    private final String code;
    private final String msg;
    private Object data;

    public UserException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public UserException(String code, String msg, Object data){
        super(msg);
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
