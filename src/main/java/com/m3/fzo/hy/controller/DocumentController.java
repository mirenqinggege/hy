package com.m3.fzo.hy.controller;

import com.m3.fzo.hy.common.AjaxResult;
import com.m3.fzo.hy.domain.system.SysDocument;
import com.m3.fzo.hy.service.ISysDocumentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class DocumentController {

    private final ISysDocumentService iSysDocumentService;

    public DocumentController(ISysDocumentService iSysDocumentService) {
        this.iSysDocumentService = iSysDocumentService;
    }

    @ApiOperation(value = "上传文档")
    @PostMapping("uploadDocument")
    public AjaxResult uploadDocument(@RequestBody SysDocument sysDocument) {
        Integer num = iSysDocumentService.uploadDocument(sysDocument);
        return AjaxResult.success("操作成功", num);
    }

    @ApiOperation(value = "获取全部文章数据")
    @GetMapping("getAllDocumentData")
    public AjaxResult getAllDocumentData() {
        return AjaxResult.success(iSysDocumentService.getAllDocumentData());
    }

    @ApiOperation(value = "查询文章页面全部字典数据")
    @GetMapping("getDocumentDictData")
    public AjaxResult getDocumentDictData(String type) {
        return AjaxResult.success("操作成功", iSysDocumentService.getDocumentDictData(type));
    }

    @ApiOperation(value = "删除文章")
    @PutMapping("delDocumentById")
    public AjaxResult delDocumentById(Integer id) {
        return AjaxResult.success("操作成功", iSysDocumentService.delDocumentById(id));
    }
}
