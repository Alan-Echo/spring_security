package com.test.security.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 管理员资源接口,需要有管理员相关权限或角色才可以访问
 * @author: ※狗尾巴草
 * @date: 2020-11-14 18:09
 **/
@RestController
@RequestMapping("admin")
public class adminController {


    @GetMapping("info")
    public String getCommon(){
        return "admin资源";
    }


}