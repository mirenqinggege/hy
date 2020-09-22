package com.m3.fzo.hy.mapper;

import com.m3.fzo.hy.domain.system.SysIcon;

import java.util.List;

public interface SysIconMapper {
    /**
     * 获取所有图标
     *
     * @return 图标集合
     */
    List<SysIcon> selectAllIcon();
}
