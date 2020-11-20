package com.m3.fzo.hy.common.enums;


public enum ResponseCode {
    SUCCESS("00000", "操作成功"),
    SERVER_ERROR("B0100","系统异常，请联系管理员"),
    CLIENT_ERROR("A0100", "操作错误，请重试"),
    USER_ERROR("B0200", "用户错误"),
    /*用户名异常*/
    USER_NAME_REPETITION("B0210","用户名已存在"),
    USER_NAME_CONTAIN_SENSITIVE_CHAR("B0211","用户名包含敏感字符"),
    /*账号异常*/
    ACCOUNT_ERROR("B0300","账号异常"),
    ACCOUNT_FREEZE("B0310", "账号被冻结"),
    ACCOUNT_DO_LOGIN_COUNT("B0311", "账号尝试登陆次数过多"),
    USERNAME_OR_PASSWORD_IS_NULL("B0320", "用户名和密码不能为空！"),
    /*登录状态异常*/
    LOGIN_EXPIRY("B0340", "登录状态过期，请重新登录！"),
    /*手机号异常*/
    PHONE_NUMBER_ERROR("B0400", "手机号异常"),
    PHONE_NUMBER_REPETITION("B0410", "手机号已存在");
    private String code;
    private String msg;

    ResponseCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseResponseCode{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
