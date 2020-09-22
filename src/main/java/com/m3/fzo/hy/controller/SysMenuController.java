package com.m3.fzo.hy.controller;

import com.m3.fzo.hy.common.AjaxResult;
import com.m3.fzo.hy.common.BaseController;
import com.m3.fzo.hy.domain.system.SysMenu;
import com.m3.fzo.hy.service.ISysMenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class SysMenuController extends BaseController {

    private final ISysMenuService menuService;

    public SysMenuController(ISysMenuService menuService) {
        this.menuService = menuService;
    }


    @GetMapping("/init/{flag}")
    public AjaxResult initMenu(@PathVariable Boolean flag) {
        List<SysMenu> menus = menuService.getTreeMenus(flag);
        return AjaxResult.success("获取菜单信息成功", menus);
    }

    @GetMapping("/getRoutes")
    public AjaxResult getRoutes() {
        List<SysMenu> treeMenus = menuService.getTreeMenus(false);
        return AjaxResult.success("获取路由信息成功", menuService.buildRoutes(treeMenus));
    }

    @GetMapping("/info")
    public AjaxResult getMenuInfo(Long menuId) {
        SysMenu menu = menuService.getMenuById(menuId);
        return AjaxResult.success("获取菜单信息成功", menu);
    }

    @GetMapping("/getRootMenu")
    public AjaxResult getRootMenu(){
        return AjaxResult.success("获取顶级菜单成功",menuService.getRootMenu());
    }

    @GetMapping("/getMenus")
    public AjaxResult getMenus(SysMenu menu){
        return AjaxResult.success("获取菜单成功",menuService.getMenus(menu));
    }

    @PostMapping("/edit")
    public AjaxResult edit(SysMenu menu) {
        return toAjaxResult(menuService.update(menu));
    }

    @PostMapping("/save")
    public AjaxResult save(@RequestBody SysMenu menu) {
        if (menu.getMenuId() == null) {
            menuService.save(menu);
            return AjaxResult.success("菜单保存成功");
        } else {
            menuService.edit(menu);
            return AjaxResult.success("菜单修改成功");
        }
    }

    @DeleteMapping("/delById/{menuId}")
    public AjaxResult deleteById(@PathVariable Long menuId){
        SysMenu menuById = menuService.getMenuById(menuId);
        if (menuById.isHasChildren()) {
            return AjaxResult.error("该菜单下存在子菜单无法删除");
        }
        menuService.removeById(menuId);
        return AjaxResult.success("删除菜单成功");
    }
}
