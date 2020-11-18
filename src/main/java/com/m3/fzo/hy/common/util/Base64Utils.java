package com.m3.fzo.hy.common.util;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.m3.fzo.hy.common.util.ruoyi.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Base64Utils {
    /**
     * 本地图片转换成base64字符串
     *将图片文件转化为字节数组字符串，
     *并对其进行Base64编码处理
     * @param imgFile    图片本地路径
     * @return
     */
    public static String ImageToBase64ByLocal(String imgFile) {//
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);

            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ImageToBase64ByLocal(data);
    }

    public static String ImageToBase64ByLocal(byte[] data){
        return new BASE64Encoder().encode(data).replaceAll("[\r\n]", "");
    }
    /**
     * base64字符串转换成图片  对字节数组字符串进行Base64解码并生成图片
     * @param imgStr        base64字符串
     * @param imgFilePath    图片存放路径
     * @return
     */
    public static boolean Base64ToImage(String imgStr,String imgFilePath) {

        // 图像数据为空
        if (StringUtils.isEmpty(imgStr)){
            return false;
        }


        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }

            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            return false;
        }

    }


}