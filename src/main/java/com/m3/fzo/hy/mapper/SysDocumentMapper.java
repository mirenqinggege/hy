package com.m3.fzo.hy.mapper;

import com.m3.fzo.hy.domain.system.SysDictData;
import com.m3.fzo.hy.domain.system.SysDocument;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

@Mapper
public interface SysDocumentMapper {

    @InsertProvider(type = com.m3.fzo.hy.provider.SysDocumentMapperProvider.class, method = "UploadDocument")
    Integer uploadDocument(SysDocument sysDocument);

    @SelectProvider(type = com.m3.fzo.hy.provider.SysDocumentMapperProvider.class, method = "getAllDocumentData")
    List<SysDocument> getAllDocumentData();

    @SelectProvider(type = com.m3.fzo.hy.provider.SysDocumentMapperProvider.class, method = "getDocumentDictData")
    List<SysDictData> getDocumentDictData(String type);

    @UpdateProvider(type = com.m3.fzo.hy.provider.SysDocumentMapperProvider.class, method = "delDocumentById")
    Integer delDocumentById(Integer id);
}
