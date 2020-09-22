package com.m3.fzo.hy.mapper;

import com.m3.fzo.hy.domain.system.SysFile;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysFileMapper {

    @InsertProvider(type = com.m3.fzo.hy.provider.SysFileMapperProvider.class,method = "SaveFileInfo")
    int saveFileInfo(SysFile file);
}
