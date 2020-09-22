package com.m3.fzo.hy.mapper;

import com.m3.fzo.hy.domain.system.SysMenu;

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

    /**
     * 根据id获取菜单
     * @param menuId id
     * @return 菜单
     */
    SysMenu selectMenuById(Long menuId);

    /**
     * 查询菜单列表
     * @param menu
     * @return
     */
    List<SysMenu> selectMenu(SysMenu menu);

    /**
     * 根据id修改菜单属性
     * @param menu 菜单
     * @return 是否成功
     */
    int updateByPrimaryKey(SysMenu menu);

    /**
     * 保存菜单信息
     * @param menu 菜单
     * @return 执行结果 1成功 0失败
     */
    int insert(SysMenu menu);

    /**
     * 根据id删除菜单
     *
     * @param menuId 菜单id
     * @return 执行结果 1成功 0失败
     */
    int deleteByMenuId(Long menuId);
}
