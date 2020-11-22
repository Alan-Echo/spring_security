package com.test.security.springsecurity.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description: 【 用户表 DTO 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @date : 2020-11-12 13:38:25
 */
@Data
public class SysUserDTO {

    // ==================== FIELDS ====================

    /** 账号 */
    private String account;

    /** 用户名 */
    private String userName;

    /** 用户密码 */
    private String password;

    /** 上一次登录时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date lastLoginTime;

    /** 账号是否可用。默认为1（可用） */
    private Integer enabled;

    /** 是否过期。默认为1（没有过期） */
    private Integer accountNotExpired;

    /** 账号是否锁定。默认为1（没有锁定） */
    private Integer accountNotLocked;

    /** 证书（密码）是否过期。默认为1（没有过期） */
    private Integer credentialsNotExpired;

    /** 修改时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date updateTime;

    /** 创建人 */
    private Integer createUser;

    /** 修改人 */
    private Integer updateUser;

    // ==================== NON-PERSISTENT ====================


    // ==================== GET AND SET METHODS ====================

}
