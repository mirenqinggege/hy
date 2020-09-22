package com.m3.fzo.hy.domain.system;

import com.m3.fzo.hy.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysDictType extends BaseEntity {
    private static final long serialVersionUID = -1339323304756962928L;

    private Long dictId;
    private String dictType;
    private String dictName;
    private Boolean status;
    private String remark;
}
