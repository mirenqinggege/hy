package com.m3.fzo.hy.controller;

import com.m3.fzo.hy.common.AjaxResult;
import com.m3.fzo.hy.common.BaseController;
import com.m3.fzo.hy.common.util.file.FileUploadUtil;
import com.m3.fzo.hy.domain.system.SysFile;
import com.m3.fzo.hy.service.ISysFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/** 文件控制器
 * @author 侯志垚
 * @date  2020-09-19 23:38
 */


@Api(description = "文件控制器")
@RestController
public class FileController extends BaseController {

    private final ISysFileService fileService;

    public FileController(ISysFileService fileService) {
        this.fileService = fileService;
    }


    @ApiOperation(value = "多文件上传")
    @PostMapping("/uploadFiles")
    public AjaxResult uploadFile(@RequestBody MultipartFile[] file) throws IOException {
        SysFile[] sysFiles =new SysFile[file.length];
        for (int i = 0; i < file.length; i++) {
            SysFile file1 = FileUploadUtil.fileUpload(file[i]);
            sysFiles[i] = file1;
        }
        return AjaxResult.success("上传成功！", sysFiles);
    }
}
