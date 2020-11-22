package com.test.security.springsecurity.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Description: 【 请求路径 实体 】
 *
 * @author : 摇曳的狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_REQUEST_PATH")
public class SysRequestPathEntity {

    // ==================== FIELDS ====================

    /**
     * 请求路径
     */
    @TableField(value = "url")
    private String url;

    /**
     * 路径描述
     */
    @TableField(value = "description")
    private String description;

    // ==================== NON-PERSISTENT ====================

    // ==================== GET AND SET METHODS ====================

}
