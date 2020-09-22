package com.m3.fzo.hy.service.impl;

import com.m3.fzo.hy.domain.system.SysDictData;
import com.m3.fzo.hy.domain.system.SysDocument;
import com.m3.fzo.hy.mapper.SysDocumentMapper;
import com.m3.fzo.hy.service.ISysDocumentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ISysDocumentServiceImpl implements ISysDocumentService {

    private final SysDocumentMapper sysDocumentMapper;

    public ISysDocumentServiceImpl(SysDocumentMapper sysDocumentMapper) {
        this.sysDocumentMapper = sysDocumentMapper;
    }

    @Override
    public Integer uploadDocument(SysDocument sysDocument) {
        sysDocument.setCreator(1);
        sysDocument.setCreatedTime(new Date());
        return sysDocumentMapper.uploadDocument(sysDocument);
    }

    @Override
    public List<SysDocument> getAllDocumentData() {
        return sysDocumentMapper.getAllDocumentData();
    }

    @Override
    public List<SysDictData> getDocumentDictData(String type) {
        return sysDocumentMapper.getDocumentDictData(type);
    }

    @Override
    public Integer delDocumentById(Integer id) {
        return sysDocumentMapper.delDocumentById(id);
    }
}
