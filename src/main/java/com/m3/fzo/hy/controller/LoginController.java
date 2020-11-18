package com.m3.fzo.hy.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.m3.fzo.hy.common.AjaxResult;
import com.m3.fzo.hy.common.BaseController;
import com.m3.fzo.hy.common.util.Base64Utils;
import com.m3.fzo.hy.common.util.Constants;
import com.m3.fzo.hy.common.util.RedisUtils;
import com.m3.fzo.hy.common.util.VerifyCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    // 验证码
    private final VerifyCode vc;
    private final RedisUtils ru;

    public LoginController(VerifyCode vc, RedisUtils ru) {
        this.vc = vc;
        this.ru = ru;
    }

    /**
     * 获取图片验证码
     * @param response 相应
     */
    @GetMapping("/captcha")
    public AjaxResult getCaptcha(HttpServletResponse response) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage image = vc.getImage();
        String code = vc.getText();
        String uuid = IdUtil.simpleUUID();
        ru.setEx(uuid, code, 5, TimeUnit.MINUTES);
        response.setHeader(Constants.VerifyCodeKey, uuid);
        ImageIO.write(image, "JPEG", outputStream);
        String s = "data:image/jpeg;base64," + Base64Utils.ImageToBase64ByLocal(outputStream.toByteArray());
        outputStream.close();
        return AjaxResult.success("获取验证码成功", s);
    }
}
