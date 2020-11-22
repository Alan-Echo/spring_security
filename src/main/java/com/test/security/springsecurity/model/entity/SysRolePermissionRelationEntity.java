package com.test.security.springsecurity.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Description: 【 角色-权限关联关系表 实体 】
 *
 * @author : 摇曳的狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_ROLE_PERMISSION_RELATION")
public class SysRolePermissionRelationEntity {

    // ==================== FIELDS ====================

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 权限ID
     */
    @TableField(value = "permission_id")
    private Integer permissionId;

    // ==================== NON-PERSISTENT ====================

    // ==================== GET AND SET METHODS ====================

}
