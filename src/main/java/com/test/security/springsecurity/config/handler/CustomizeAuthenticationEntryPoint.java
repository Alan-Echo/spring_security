package com.test.security.springsecurity.config.handler;



import com.alibaba.fastjson.JSON;
import com.test.security.springsecurity.utils.JsonResult;
import com.test.security.springsecurity.utils.ResultCode;
import com.test.security.springsecurity.utils.ResultTool;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @description: 匿名用户访问无权限资源时的异常
 * @author: ※狗尾巴草
 * @date: 2020-11-13 14:15
 **/
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint{
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JsonResult result = ResultTool.fail(ResultCode.USER_NOT_LOGIN);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }



}

