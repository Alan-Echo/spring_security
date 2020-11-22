package com.test.security.springsecurity.model.dto;

import lombok.Data;



/**
 * Description: 用户角色表

 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @date : 2020-11-12 13:38:24
 */
@Data
public class SysRoleDTO  {

    // ==================== FIELDS ====================

    /** 角色名 */
    private String roleName;

    /** 角色说明 */
    private String roleDescription;

    /** 角色代码 */
    private String roleCode;

    // ==================== NON-PERSISTENT ====================


    // ==================== GET AND SET METHODS ====================

}
