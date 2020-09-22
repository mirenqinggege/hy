package com.m3.fzo.hy.service;


import com.m3.fzo.hy.domain.system.SysDictData;
import com.m3.fzo.hy.domain.system.SysDocument;

import java.util.List;

public interface ISysDocumentService {

    Integer uploadDocument(SysDocument sysDocument);

    List<SysDocument> getAllDocumentData();

    List<SysDictData> getDocumentDictData(String type);

    Integer delDocumentById(Integer id);
}
