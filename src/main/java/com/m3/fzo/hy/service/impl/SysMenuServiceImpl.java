package com.m3.fzo.hy.service.impl;

import com.m3.fzo.hy.domain.SysMenu;
import com.m3.fzo.hy.mapper.SysMenuMapper;
import com.m3.fzo.hy.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class SysMenuServiceImpl implements ISysMenuService {
    private final SysMenuMapper menuMapper;

    public SysMenuServiceImpl(SysMenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    /**
     * 获取菜单
     *
     * @return 菜单集合
     */
    @Override
    public List<SysMenu> getMenus() {
        List<SysMenu> menus = menuMapper.selectMenuByParentIdIsNull();
        menus.forEach(this::getChildMenu);
        return menus;
    }

    private void getChildMenu(SysMenu menu){
        List<SysMenu> menus = menuMapper.selectMenuByParentId(menu.getMenuId());
        if (menus.isEmpty()) {
            return;
        }
        menus.forEach(this::getChildMenu);
        menu.setChild(menus);
        menu.setHasChildren(true);
    }

    /**
     * 根据id获取菜单
     *
     * @param menuId id
     * @return 菜单
     */
    @Override
    public SysMenu getMenuById(Long menuId) {
        return menuMapper.selectMenuById(menuId);
    }

    /**
     * 根据主键修改菜单
     *
     * @param menu 菜单
     * @return 是否成功
     */
    @Override
    public int update(SysMenu menu) {
        menu.setUpdateTime(Calendar.getInstance().getTime());
        return menuMapper.updateByPrimaryKey(menu);
    }
}
