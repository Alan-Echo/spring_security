//package com.test.security.springsecurity.config.handler;
//
//
//import com.alibaba.fastjson.JSON;
//import com.test.security.springsecurity.utils.JsonResult;
//import com.test.security.springsecurity.utils.ResultCode;
//import com.test.security.springsecurity.utils.ResultTool;
//import org.springframework.security.web.session.SessionInformationExpiredEvent;
//import org.springframework.security.web.session.SessionInformationExpiredStrategy;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @description: 会话信息过期策略
// * @author: ※狗尾巴草
// * @date: 2020-11-13 18:02
// **/
//@Component
//public class CustomizeSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
//    @Override
//    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
//        JsonResult result = ResultTool.fail(ResultCode.USER_ACCOUNT_USE_BY_OTHERS);
//        HttpServletResponse httpServletResponse = sessionInformationExpiredEvent.getResponse();
//        httpServletResponse.setContentType("text/json;charset=utf-8");
//        httpServletResponse.getWriter().write(JSON.toJSONString(result));
//    }
//}
//
