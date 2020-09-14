package com.m3.fzo.hy.domain;

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
    private Long menuId ;
    /** 父菜单id */
    private Long parentId ;
    /** 排序 */
    private Integer orderNum;
    /** 菜单名 */
    private String name ;
    /** 链接 */
    private String link ;
    /** 图标 */
    private String icon ;
    /** 状态 */
    private String status ;
    /** 子菜单 */
    private List<SysMenu> child = new ArrayList<>();
}
