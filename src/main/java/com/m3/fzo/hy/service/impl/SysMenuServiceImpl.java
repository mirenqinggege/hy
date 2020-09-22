package com.m3.fzo.hy.service.impl;

import com.m3.fzo.hy.common.Constant;
import com.m3.fzo.hy.domain.system.SysMenu;
import com.m3.fzo.hy.domain.system.vo.RouterVo;
import com.m3.fzo.hy.mapper.SysMenuMapper;
import com.m3.fzo.hy.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class SysMenuServiceImpl implements ISysMenuService {
    public static final String MENU_TYPE = "M",
            BUTTON_TYPE = "B",
            OUT_HREF = "_blank",
            IN_HREF = "_self",
            DEFAULT_COMPONENT = "HelloWorld";

    private final SysMenuMapper menuMapper;

    public SysMenuServiceImpl(SysMenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    /**
     * 获取菜单
     *
     * @return 菜单集合
     * @param b
     */
    @Override
    public List<SysMenu> getTreeMenus(boolean b) {
        SysMenu sysMenu = new SysMenu();
        if (!b) {
            sysMenu.setStatus(Constant.MENU_ENABLED);
        }
        List<SysMenu> menus = menuMapper.selectMenu(sysMenu);
        return buildMenuTree(menus);
    }

    private List<SysMenu> buildMenuTree(List<SysMenu> menus) {
        List<SysMenu> result = new ArrayList<>();
        for (SysMenu menu : menus) {
            if(menu.getParentId() == null){
                recursionFn(menus, menu);
                menu.setHasChildren(!menu.getChild().isEmpty());
                result.add(menu);
            }
        }

        if (result.isEmpty()) {
            return menus;
        }
        return result;
    }

    private void recursionFn(List<SysMenu> menus, SysMenu menu) {
        List<SysMenu> list = getChildMenu(menus, menu);
        menu.setChild(list);
        if (!list.isEmpty()) {
            for (SysMenu sysMenu : list) {
                recursionFn(menus, sysMenu);
            }
        }
    }

    private List<SysMenu> getChildMenu(List<SysMenu> menus,SysMenu menu) {
        List<SysMenu> list = new ArrayList<>();
        for (SysMenu sysMenu : menus) {
            if(sysMenu.getParentId() != null && sysMenu.getParentId().longValue() == menu.getMenuId().longValue()){
                list.add(sysMenu);
            }
        }
        return list;
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

    /**
     * 根据树菜单构建路由
     *
     * @param treeMenus 树菜单
     * @return 路由集合
     */
    @Override
    public List<RouterVo> buildRoutes(List<SysMenu> treeMenus) {
        List<RouterVo> routes = new ArrayList<>();
        treeMenus.forEach(menu -> {
            RouterVo router = new RouterVo();
            router.setPath(getRouterPath(menu));
            router.setName(getRouterName(menu));
            router.setComponent(getComponent(menu));
            List<SysMenu> child = menu.getChild();
            if (!child.isEmpty()) {
                router.setChildren(buildRoutes(child));
            }
            routes.add(router);
        });
        return routes;
    }

    private String getRouterName(SysMenu menu) {
        return menu.getName();
    }

    private String getRouterPath(SysMenu menu) {
        return menu.getPath();
    }

    private String getComponent(SysMenu menu) {
        String component = menu.getComponent();
        if (MENU_TYPE.equals(menu.getType())) {
            component = DEFAULT_COMPONENT;
        }
        return component;
    }

    /**
     * 保存菜单
     *
     * @param menu 菜单
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int save(SysMenu menu) {
        return menuMapper.insert(menu);
    }

    /**
     * 修改菜单
     *
     * @param menu 菜单
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int edit(SysMenu menu) {
        return menuMapper.updateByPrimaryKey(menu);
    }

    /**
     * 获取顶级菜单
     *
     * @return 菜单集合
     */
    @Override
    public List<SysMenu> getRootMenu() {
        return menuMapper.selectMenuByParentIdIsNull();
    }

    /**
     * 获取菜单
     *
     * @param menu
     * @return 菜单集合
     */
    @Override
    public List<SysMenu> getMenus(SysMenu menu) {
        return menuMapper.selectMenu(menu);
    }

    /**
     * 根据id删除菜单
     *
     * @param menuId 菜单id
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int removeById(Long menuId) {
        return menuMapper.deleteByMenuId(menuId);
    }
}
