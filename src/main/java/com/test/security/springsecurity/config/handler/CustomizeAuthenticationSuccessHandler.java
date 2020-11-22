package com.test.security.springsecurity.config.handler;



import com.alibaba.fastjson.JSON;
import com.test.security.springsecurity.model.entity.SysUserEntity;
import com.test.security.springsecurity.model.vo.SysUserVO;
import com.test.security.springsecurity.server.SysUserService;
import com.test.security.springsecurity.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @description: 登录成功处理器
 * @author: ※狗尾巴草
 * @date: 2020-11-13 14:19
 **/
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //更新用户表上次登录时间、更新人、更新时间等字段
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUserEntity sysUser = sysUserService.selectByName(userDetails.getUsername());
        sysUser.setLast_login_time(new Date());
        sysUser.setUpdate_time(new Date());
        sysUser.setUpdate_user(sysUser.getId());
        sysUserService.updateById(sysUser);

        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展

        //  获取用户权限
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        ArrayList<String> list = new ArrayList<>();
        String role = "";
        for (GrantedAuthority authority : authorities){
            role += authority.getAuthority()+",";
            list.add(authority.getAuthority());
        }
        role=role.substring(0,role.length()-1);
        //将权限放入token中
        String token = JwtTokenUtils.createToken(userDetails.getUsername(), role);
        sysUser.setToken(JwtTokenUtils.TOKEN_PREFIX+token);

        sysUser.setAuthorities(list);
        SysUserVO userVO = ConvertUtils.sourceToTarget(sysUser, SysUserVO.class);

        //返回json数据
        JsonResult result = ResultTool.success();
        result.setData(userVO);


        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}

