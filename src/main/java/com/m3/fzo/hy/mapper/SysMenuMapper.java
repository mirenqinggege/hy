package com.m3.fzo.hy.mapper;

import com.m3.fzo.hy.domain.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    /**
     * 查询顶级菜单
     * @return 菜单集合
     */
    List<SysMenu> selectMenuByParentIdIsNull();

    /**
     * 查询子菜单
     * @return 菜单集合
     */
    List<SysMenu> selectMenuByParentId(Long parentId);
}
