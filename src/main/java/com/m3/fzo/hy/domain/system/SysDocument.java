package com.m3.fzo.hy.domain.system;

import lombok.Data;

import java.util.Date;


@Data
public class SysDocument{
    /** 主键 */
    private Integer id ;
    /** MD源代码*/
    private String md;
    /** 文章标题*/
    private String title;
    /** html代码 */
    private String html ;
    /** 创建时间 */
    private Date createdTime ;
    /** 创建人 */
    private Integer creator ;
    /** 查看次数 */
    private Integer checkNum ;
    /** 是否删除(0 是 1 否) */
    private Integer isDel ;
    /** 文章类型 */
    private String type ;


}