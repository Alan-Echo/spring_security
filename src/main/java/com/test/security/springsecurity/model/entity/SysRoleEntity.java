package com.test.security.springsecurity.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Description: 【 用户角色表 实体 】
 *
 * @author : 摇曳的狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_ROLE")
public class SysRoleEntity  {

    // ==================== FIELDS ====================

    /**
     * 角色名
     */
    @TableField(value = "id")
    private Integer id;

    /**
     * 角色名
     */
    @TableField(value = "role_name")
    private String role_name;

    /**
     * 角色说明
     */
    @TableField(value = "role_description")
    private String role_description;

    /**
     * 角色code
     */
    @TableField(value = "role_code")
    private String role_code;

    // ==================== NON-PERSISTENT ====================

    // ==================== GET AND SET METHODS ====================

}
