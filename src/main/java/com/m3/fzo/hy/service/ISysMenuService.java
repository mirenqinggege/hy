package com.m3.fzo.hy.service;

import com.m3.fzo.hy.domain.SysMenu;

import java.util.List;

public interface ISysMenuService {
    /**
     * 获取菜单
     * @return 菜单集合
     */
    List<SysMenu> getMenus();
}
