package com.m3.fzo.hy.common;

public class BaseController {

    public static AjaxResult toAjaxResult(int rows){
        return rows > 0 ? AjaxResult.success(): AjaxResult.error();
    }
}
