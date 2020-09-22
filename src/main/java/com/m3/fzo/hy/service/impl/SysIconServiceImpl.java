package com.m3.fzo.hy.service.impl;

import com.m3.fzo.hy.domain.system.SysIcon;
import com.m3.fzo.hy.mapper.SysIconMapper;
import com.m3.fzo.hy.service.ISysIconService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysIconServiceImpl implements ISysIconService {

    private final SysIconMapper mapper;

    public SysIconServiceImpl(SysIconMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 获取所有图标
     *
     * @return 图标集合
     */
    @Override
    public List<SysIcon> getAllIcon() {
        return mapper.selectAllIcon();
    }
}
