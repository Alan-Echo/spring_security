package com.test.security.springsecurity.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Description: 【 权限表 实体 】
 *
 * @author : 摇曳的狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_PERMISSION")
public class SysPermissionEntity  {

    // ==================== FIELDS ====================

    /**
     * 权限CODE
     */
    @TableField(value = "permission_code")
    private String permission_code;

    /**
     * 权限名
     */
    @TableField(value = "permission_name")
    private String permission_name;

    // ==================== NON-PERSISTENT ====================

    // ==================== GET AND SET METHODS ====================

}
