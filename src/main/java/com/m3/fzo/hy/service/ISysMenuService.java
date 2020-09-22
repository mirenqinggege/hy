package com.m3.fzo.hy.service;

import com.m3.fzo.hy.domain.system.SysMenu;
import com.m3.fzo.hy.domain.system.vo.RouterVo;

import java.util.List;

public interface ISysMenuService {
    /**
     * 获取菜单
     * @return 菜单集合
     * @param b 是否包含禁用菜单
     */
    List<SysMenu> getTreeMenus(boolean b);

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

    /**
     * 根据树菜单构建路由
     * @param treeMenus 树菜单
     * @return 路由集合
     */
    List<RouterVo> buildRoutes(List<SysMenu> treeMenus);

    /**
     * 保存菜单
     * @param menu 菜单
     * @return 执行结果 1成功 0失败
     */
    int save(SysMenu menu);

    /**
     * 修改菜单
     * @param menu 菜单
     * @return 执行结果 1成功 0失败
     */
    int edit(SysMenu menu);

    /**
     * 获取顶级菜单
     * @return 菜单集合
     */
    List<SysMenu> getRootMenu();

    /**
     * 获取菜单
     * @return 菜单集合
     */
    List<SysMenu> getMenus(SysMenu menu);

    /**
     * 根据id删除菜单
     * @param menuId 菜单id
     * @return 执行结果 1成功 0失败
     */
    int removeById(Long menuId);
}
