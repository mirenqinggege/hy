package com.m3.fzo.hy.interceptors;

import cn.hutool.json.JSONUtil;
import com.m3.fzo.hy.common.AjaxResult;
import com.m3.fzo.hy.common.exception.UserException;
import com.m3.fzo.hy.common.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final TokenUtil tu;

    public LoginInterceptor(TokenUtil tu) {
        this.tu = tu;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        try {
            tu.validToken(request);
        } catch (UserException e) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(JSONUtil.toJsonStr(AjaxResult.error(e)));
            response.getWriter().close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
