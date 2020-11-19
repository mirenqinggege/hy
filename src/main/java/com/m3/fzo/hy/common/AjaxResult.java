package com.m3.fzo.hy.common;

import com.m3.fzo.hy.common.enums.ResponseCode;
import com.m3.fzo.hy.common.exception.UserException;
import com.m3.fzo.hy.common.util.ruoyi.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

@EqualsAndHashCode(callSuper = true)
@Data
public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = -8551145381836253260L;
    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final String DATA = "data";

    public AjaxResult(){}
    public AjaxResult(String code, String msg, Object data){
        super();
        put(CODE, code);
        put(MSG, msg);
        if (StringUtils.isNotNull(data)) {
            put(DATA, data);
        }
    }

    public AjaxResult(String code, String msg){
        this(code, msg, null);
    }

    public static AjaxResult success(String code, String msg, Object data){
        return new AjaxResult(code, msg, data);
    }

    public static AjaxResult success(String msg, Object data) {
        return success(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static AjaxResult success(String msg) {
        return success(msg, null);
    }

    public static AjaxResult success(Object data) {
        return success(ResponseCode.SUCCESS.getMsg(),data);
    }

    public static AjaxResult success() {
        return success(ResponseCode.SUCCESS.getMsg(),null);
    }

    public static AjaxResult success(ResponseCode responseCode, Object data){
        return new AjaxResult(responseCode.getCode(), responseCode.getMsg(), data);
    }

    public static AjaxResult success(ResponseCode responseCode){
        return new AjaxResult(responseCode.getCode(), responseCode.getMsg(), null);
    }

    public static AjaxResult error(String code, String msg, Object data) {
        return new AjaxResult(code, msg, data);
    }

    public static AjaxResult error(UserException e){
        return error(e.getCode(), e.getMsg(), e.getData());
    }

    public static AjaxResult error(String msg, Object data){
        return new AjaxResult("B0100", msg, data);
    }

    public static AjaxResult error(String msg){
        return error(msg, null);
    }

    public static AjaxResult error(ResponseCode responseCode, Object data){
        return success(responseCode, data);
    }

    public static AjaxResult error(ResponseCode responseCode){
        return success(responseCode, null);
    }

    public static AjaxResult error(){
        return error(ResponseCode.SERVER_ERROR);
    }

}
