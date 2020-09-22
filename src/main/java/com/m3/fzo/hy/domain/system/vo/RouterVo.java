package com.m3.fzo.hy.domain.system.vo;

import lombok.Data;

import java.util.List;

@Data
public class RouterVo {
    private String name;
    private String path;
    private String component;
    private MetaVo meta;
    private List<RouterVo> children;
}
