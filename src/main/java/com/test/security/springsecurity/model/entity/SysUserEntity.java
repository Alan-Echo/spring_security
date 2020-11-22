package com.test.security.springsecurity.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Description: 【 用户表 实体 】
 *
 * @author : 摇曳的狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_USER")
public class SysUserEntity  {

    // ==================== FIELDS ====================
    @TableField(value = "id")
    private Integer id;

    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String user_name;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 上一次登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    @TableField(value = "last_login_time")
    private Date last_login_time;

    /**
     * 账号是否可用。默认为1（可用）
     */
    @TableField(value = "enabled")
    private Integer enabled;

    /**
     * 是否过期。默认为1（没有过期）
     */
    @TableField(value = "account_not_expired")
    private Integer account_not_expired;

    /**
     * 账号是否锁定。默认为1（没有锁定）
     */
    @TableField(value = "account_not_locked")
    private Integer account_not_locked;

    /**
     * 证书（密码）是否过期。默认为1（没有过期）
     */
    @TableField(value = "credentials_not_expired")
    private Integer credentials_not_expired;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    @TableField(value = "update_time")
    private Date update_time;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    private Integer create_user;

    /**
     * 修改人
     */
    @TableField(value = "update_user")
    private Integer update_user;

    // ==================== NON-PERSISTENT ====================
    @TableField(exist = false)
    private List<String> authorities;

    @TableField(exist = false)
    private String token;

    // ==================== GET AND SET METHODS ====================

}
