package com.m3.fzo.hy.service.impl;

import com.m3.fzo.hy.domain.system.SysFile;
import com.m3.fzo.hy.mapper.SysFileMapper;
import com.m3.fzo.hy.service.ISysFileService;
import org.springframework.stereotype.Service;

@Service
public class SysFIleServiceImpl implements ISysFileService {

    private final SysFileMapper fileMapper;

    public SysFIleServiceImpl(SysFileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public int saveFileInfo(SysFile file) {
        return fileMapper.saveFileInfo(file);
    }
}
