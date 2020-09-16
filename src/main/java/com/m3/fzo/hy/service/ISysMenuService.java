package com.m3.fzo.hy.service;

import com.m3.fzo.hy.domain.SysMenu;

import java.util.List;

public interface ISysMenuService {
    /**
     * 获取菜单
     * @return 菜单集合
     */
    List<SysMenu> getMenus();

    /**
     * 根据id获取菜单
     * @param menuId id
     * @return 菜单
     */
    SysMenu getMenuById(Long menuId);

    /**
     * 根据主键修改菜单
     * @param menu 菜单
     * @return 是否成功
     */
    int update(SysMenu menu);
}
