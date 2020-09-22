package com.m3.fzo.hy.common.util.file;

import com.m3.fzo.hy.common.util.Md5Utils;
import com.m3.fzo.hy.common.util.date.DateUtils;
import com.m3.fzo.hy.common.util.ruoyi.Global;
import com.m3.fzo.hy.domain.system.SysFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.Date;


public class FileUploadUtil {

    private static final String FILE_PATH = Global.getConfig("profile.path");

    public static SysFile fileUpload(MultipartFile file1) throws IOException {
        if (file1.isEmpty()) {
            return null;
        }

        String suffix = file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf("."));

        //生成存放路径
        String existPath = isExistPath();

        //获取文件大小
        String size = getFileSize(file1);

        //编码文件名
        String hash = Md5Utils.hash(file1.getOriginalFilename()) + suffix;

        //文件摘要

        File file2 = new File(existPath + hash);

        //上传到指定路径文件夹内
        file1.transferTo(file2);

        return new SysFile(hash, (existPath + hash), 0, (file1.getOriginalFilename()), file1.getContentType(), size, "hy", new Date());
    }

    /**
     * 判断路径存不存在
     */
    public static String isExistPath() {
        String path = FILE_PATH + DateUtils.datePath() + "/";
        File f = new File(path);
        //判断路径存不存在或者是不是文件夹
        if (!f.exists() || f.isFile()) {
            f.mkdirs();
        }
        return path;
    }


    public static String getFileSize(MultipartFile file) {
        String result = "";
        long rSize;

        //kb → mb
        long ktm = 1024;

        //mb → gb
        long mtg = ktm * 1024;

        //gb → tb
        long gtt = mtg * 1024;

        long size = file.getSize();

        if (size >= gtt) {
            rSize = size / gtt;
            result = rSize + "TB";
        } else if (size >= mtg) {
            rSize = size / mtg;
            result = rSize + "GB";
        } else if (size >= ktm) {
            rSize = size / ktm;
            result = rSize + "MB";
        } else {
            result = size + "KB";
        }
        return result;
    }
}
