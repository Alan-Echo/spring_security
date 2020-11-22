package com.test.security.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 公共资源接口,无需权限或绝便可访问
 * @author: ※狗尾巴草
 * @date: 2020-11-13 14:29
 **/
@RestController
@RequestMapping("common")
public class commonCOntroller {


    @GetMapping("info")
    public String getCommon(){
        return "公共资源";
    }


}
