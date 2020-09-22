package com.m3.fzo.hy.domain.system;
import com.m3.fzo.hy.common.BaseEntity;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;


public class SysFile extends BaseEntity {
    /** 主键 */
    @Id
    private Integer id ;
    /** 文件名称 */
    private String name ;
    /** 创建时间 */
    private Date createTime ;
    /** 文件路径 */
    private String path ;
    /** 数据状态(0 否 1 是) */
    private Integer isDel ;
    /** 原文件名 */
    private String originalName ;
    /** 文件类型 */
    private String type ;
    /** 文件大小 */
    private String size ;
    /** 文件摘要 */
    private String md5 ;

    public SysFile(String name, String path, Integer isDel, String originalName, String type, String size, String md5, Date createTime){
        this.path = path;
        this.isDel = isDel;
        this.originalName = originalName;
        this.type = type;
        this.size = size;
        this.md5 = md5;
        this.name = name;
        this.createTime = createTime;
    }


    /** 主键 */
    public Integer getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(Integer id){
        this.id = id;
    }
    /** 文件名称 */
    public String getName(){
        return this.name;
    }
    /** 文件名称 */
    public void setName(String name){
        this.name = name;
    }
    /** 创建时间 */
    public Date getCreateTime(){
        return this.createTime;
    }
    /** 创建时间 */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
    /** 文件路径 */
    public String getPath(){
        return this.path;
    }
    /** 文件路径 */
    public void setPath(String path){
        this.path = path;
    }
    /** 数据状态(0 否 1 是) */
    public Integer getIsDel(){
        return this.isDel;
    }
    /** 数据状态(0 否 1 是) */
    public void setIsDel(Integer isDel){
        this.isDel = isDel;
    }
    /** 原文件名 */
    public String getOriginalName(){
        return this.originalName;
    }
    /** 原文件名 */
    public void setOriginalName(String originalName){
        this.originalName = originalName;
    }
    /** 文件类型 */
    public String getType(){
        return this.type;
    }
    /** 文件类型 */
    public void setType(String type){
        this.type = type;
    }
    /** 文件大小 */
    public String getSize(){
        return this.size;
    }
    /** 文件大小 */
    public void setSize(String size){
        this.size = size;
    }
    /** 文件摘要 */
    public String getMd5(){
        return this.md5;
    }
    /** 文件摘要 */
    public void setMd5(String md5){
        this.md5 = md5;
    }
}