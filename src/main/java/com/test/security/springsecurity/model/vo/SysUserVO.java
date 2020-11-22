package com.test.security.springsecurity.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @description: 说明
 * @author: ※狗尾巴草
 * @date: 2020-11-22 1:24
 **/
@Data
public class SysUserVO {


    private Integer id;

    /**
     * 账号
     */
    private String account;


    /**
     * 上一次登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date last_login_time;

    /**
     * 账号是否可用。默认为1（可用）
     */
    private Integer enabled;

    /**
     * 是否过期。默认为1（没有过期）
     */
    private Integer account_not_expired;

    /**
     * 账号是否锁定。默认为1（没有锁定）
     */
    private Integer account_not_locked;

    /**
     * 证书（密码）是否过期。默认为1（没有过期）
     */
    private Integer credentials_not_expired;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date update_time;

    /** 权限列表 */
    private List<String> authorities;

    /** token */
    private String token;



}
