package com.m3.fzo.hy.domain.system;

import com.m3.fzo.hy.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysIcon extends BaseEntity {
    private static final long serialVersionUID = -8793635530188259374L;

    private Long iconId;
    private String className;
}
