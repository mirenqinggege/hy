package com.m3.fzo.hy.provider;

import com.m3.fzo.hy.domain.system.SysFile;
import org.apache.ibatis.jdbc.SQL;

public class SysFileMapperProvider {

    public String SaveFileInfo(SysFile file) {
        return new SQL() {{
            INSERT_INTO("sys_file");
            VALUES("NAME", "#{name}");
            VALUES("CREATE_TIME", "#{createTime}");
            VALUES("PATH", "#{path}");
            VALUES("IS_DEL", "#{isDel}");
            VALUES("ORIGINAL_NAME", "#{path}");
            VALUES("TYPE", "#{type}");
            VALUES("SIZE", "#{size}");
            VALUES("MD5", "#{md5}");
        }}.toString();
    }
}
