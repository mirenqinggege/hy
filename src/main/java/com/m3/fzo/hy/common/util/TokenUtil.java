package com.m3.fzo.hy.common.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.m3.fzo.hy.common.Constant;
import com.m3.fzo.hy.common.exception.UserException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户令牌工具类
 */
@Component
public class TokenUtil {

    @Value("${Token.sing}")
    private String sing;
    @Value("${Token.expire}")
    private Long expire;

    public void validToken(String token) throws UserException {
        String data = StrUtil.format("验证Token: {}", token);
        if (StrUtil.isEmpty(token)) {
            throw new UserException("B0212", "登录超时，请重新登录！", data);
        }
        String loginInfo = Base64.decodeStr(token);
        String[] split = loginInfo.split("\\.");
        if (ArrayUtil.isEmpty(split) || split.length != 3) {
            throw new UserException("B0213", "令牌失效，请重新登录！", data);
        }
        String sing = split[1];
        if (!StrUtil.equals(sing, this.sing)) {
            throw new UserException("B0213", "令牌失效，请重新登录！", data);
        }
        long currentTime = System.currentTimeMillis();
        long expire = Long.parseLong(split[2]);
        if (currentTime > expire) {
            throw new UserException("B0212", "登录超时，请重新登录！", data);
        }
    }

    public String getUserName(String token) throws UserException {
        validToken(token);
        String loginInfo = Base64.decodeStr(token);
        String[] split = loginInfo.split("\\.");
        return split[1];
    }

    public String generateToken(HttpServletRequest request) throws UserException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
            throw new UserException("B0214", "用户名和密码不能为空");
        }
        String loginInfo = StrUtil.format("{}.{}.{}", username, sing, System.currentTimeMillis() + expire);
        String token = Base64.encode(loginInfo);
        return token;
    }

    public String getSing() {
        return sing;
    }

    public Long getExpire() {
        return expire;
    }

    public void validToken(HttpServletRequest request) throws UserException {
        String token = request.getHeader(Constant.USER_TOKEN_KEY);
        validToken(token);
    }
}
