package com.test.security.springsecurity.model.dto;

import lombok.Data;


/**
 * Description: 权限表
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @date : 2020-11-12 13:38:25
 */
@Data
/** 权限表 */
public class SysPermissionDTO {

    // ==================== FIELDS ====================

    /** 权限CODE */
    private String permissionCode;

    /** 权限名 */
    private String permissionName;



}
