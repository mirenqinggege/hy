package com.m3.fzo.hy.domain.system;

import com.m3.fzo.hy.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenu extends BaseEntity {
    private static final long serialVersionUID = 5493592891201281018L;
    /** 菜单id */
    private Long menuId;
    /** 父菜单id */
    private Long parentId;
    /** 父菜单名称 */
    private String parentName;
    /** 排序 */
    private Integer orderNum;
    /** 菜单名 */
    private String name;
    /** 菜单类型（B按钮  M菜单） */
    private String type;
    /** 路由路径 */
    private String path ;
    /** 目标窗口 */
    private String target;
    /** 组件路径 */
    private String component;
    /** 图标 */
    private String icon;
    /** 状态 */
    private String status;
    /** 是否存在子菜单 */
    private boolean hasChildren;
    /** 子菜单 */
    private List<SysMenu> child = new ArrayList<>();
}
