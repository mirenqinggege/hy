package com.m3.fzo.hy.common;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 102212121241650287L;
    private Date createTime;
    private Date updateTime;
    private MultipartFile file;
    private List<MultipartFile> files;
    private Map<String,Object> params;

}
