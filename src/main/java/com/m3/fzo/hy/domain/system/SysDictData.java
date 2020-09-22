package com.m3.fzo.hy.domain.system;

import com.m3.fzo.hy.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
public class SysDictData extends BaseEntity {
    private static final long serialVersionUID = -6371514635316085920L;

    private Long dataId;
    private String dictType;
    private String dictLabel;
    private String dictValue;
}
