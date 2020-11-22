package com.test.security.springsecurity;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description: 说明
 * @author: ※狗尾巴草
 * @date: 2020-11-13 17:47
 **/

public class test {

    @Test
    public void getPass(){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);


    }

}
