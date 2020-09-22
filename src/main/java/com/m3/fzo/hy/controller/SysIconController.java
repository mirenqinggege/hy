package com.m3.fzo.hy.controller;

import com.m3.fzo.hy.common.AjaxResult;
import com.m3.fzo.hy.common.BaseController;
import com.m3.fzo.hy.service.ISysIconService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/icon")
public class SysIconController extends BaseController {
    private final ISysIconService iconService;

    public SysIconController(ISysIconService iconService) {
        this.iconService = iconService;
    }


    @GetMapping("/getAllIcon")
    public AjaxResult getAllIcon(){
        return AjaxResult.success("获取所有图标成功",iconService.getAllIcon());
    }
}
