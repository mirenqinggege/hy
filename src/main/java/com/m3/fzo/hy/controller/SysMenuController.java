package com.m3.fzo.hy.controller;

import com.m3.fzo.hy.common.AjaxResult;
import com.m3.fzo.hy.common.BaseController;
import com.m3.fzo.hy.domain.SysMenu;
import com.m3.fzo.hy.service.ISysMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class SysMenuController extends BaseController {

    private final ISysMenuService menuService;

    public SysMenuController(ISysMenuService menuService) {
        this.menuService = menuService;
    }


    @GetMapping("/init")
    public AjaxResult initMenu(){
        List<SysMenu> menus = menuService.getMenus();
        return AjaxResult.success(menus);
    }

    @GetMapping("/info")
    public AjaxResult getMenuInfo(Long menuId){
        SysMenu menu = menuService.getMenuById(menuId);
        return AjaxResult.success("获取菜单信息成功", menu);
    }

    @PostMapping("/edit")
    public AjaxResult edit(SysMenu menu){
        return toAjaxResult(menuService.update(menu));
    }
}
