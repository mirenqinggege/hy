package com.m3.fzo.hy.provider;

import com.m3.fzo.hy.domain.system.SysDocument;
import org.apache.ibatis.jdbc.SQL;

public class SysDocumentMapperProvider {


    /**
     * 上传文章(添加文章)
     *
     * @return num
     * @author 侯志垚
     */

    public String UploadDocument(SysDocument sysDocument) {
        return new SQL() {{
            INSERT_INTO("sys_document");
            VALUES("TITLE", "#{title}");
            VALUES("MD", "#{md}");
            VALUES("HTML", "#{html}");
            VALUES("CREATED_TIME", "#{createdTime}");
            VALUES("CREATOR", "#{creator}");
            VALUES("CHECK_NUM", "#{checkNum}");
            VALUES("ISDEL", "#{isDel}");
            VALUES("TYPE", "#{type}");
        }}.toString();
    }

    /**
     * 获取所有文章数据
     *
     * @return List<Sysdocument>
     * @author 侯志垚
     */
    public String getAllDocumentData() {
        return new SQL() {{
            SELECT("ID", "TITLE, MD, CREATED_TIME createdTime, CREATOR, CHECK_NUM checkNum, ISDEL, TYPE");
            FROM("sys_document");
            WHERE("isDel =" + 1);
        }}.toString();
    }


    /**
     * 获取文章管理页面所有字典数据
     *
     * @author 侯志垚
     */

    public String getDocumentDictData(String type) {
        return new SQL() {{
            SELECT("data_id id", "dict_type dictType", "dict_label dictLabel", "dict_value dictValue", "create_time createTime", "update_time updateTime");
            FROM("sys_dict_data");
            WHERE("dict_type = '" + type + "'");
        }}.toString();
    }

    /**
     * 删除文章
     *
     * @author 侯志垚
     */
    public String delDocumentById(Integer id) {
        return new SQL() {
            {
                UPDATE("sys_document");
                SET("ISDEL = 0");
                WHERE("ID = " + id);
            }
        }.toString();
    }
}
