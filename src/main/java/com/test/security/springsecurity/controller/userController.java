package com.test.security.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 普通用户资源接口,需要有普通相关权限或角色才可以访问
 * @author: ※狗尾巴草
 * @date: 2020-11-13 12:43
 **/
@RestController
@RequestMapping("user")
public class userController {

    @GetMapping("getUser")
    public String getUser(){
        return "getUser";
    }


}
