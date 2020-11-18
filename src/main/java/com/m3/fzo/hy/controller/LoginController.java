package com.m3.fzo.hy.controller;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.m3.fzo.hy.common.AjaxResult;
import com.m3.fzo.hy.common.BaseController;
import com.m3.fzo.hy.common.util.Base64Utils;
import com.m3.fzo.hy.common.util.Constants;
import com.m3.fzo.hy.common.util.RedisUtils;
import com.m3.fzo.hy.common.util.VerifyCode;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
        ImageIO.write(image, "JPEG", outputStream);
        String s = "data:image/jpeg;base64," + Base64Utils.ImageToBase64ByLocal(outputStream.toByteArray());
        outputStream.close();
        Map<String, String> map = new HashMap<>(2);
        map.put("captcha", s);
        map.put(Constants.VerifyCodeKey, uuid);
        return AjaxResult.success("获取验证码成功", map);
    }

    /**
     * 登录方法
     * @param request 请求
     * @return 结果
     */
    @PostMapping()
    public AjaxResult login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String header = request.getHeader(Constants.VerifyCodeKey);
        String realCode;
        if (StrUtil.isEmpty(header) || StrUtil.isEmpty((realCode = ru.get(header)))) {
            return AjaxResult.error("验证码已过期");
        }
        if (!realCode.equalsIgnoreCase(code)) {
            return AjaxResult.error("验证码错误");
        } else {
            ru.delete(header);
        }
        return AjaxResult.success("登录成功！");
    }
}
