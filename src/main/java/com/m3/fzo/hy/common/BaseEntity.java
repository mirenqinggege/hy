package com.m3.fzo.hy.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 102212121241650287L;
    private Date createTime;
    private Date updateTime;
    private Map<String,Object> params;

}
