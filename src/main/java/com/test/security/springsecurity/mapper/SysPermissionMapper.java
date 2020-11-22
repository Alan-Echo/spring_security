package com.test.security.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.security.springsecurity.model.dto.SysPermissionDTO;
import com.test.security.springsecurity.model.entity.SysPermissionEntity;
import com.test.security.springsecurity.model.entity.SysRolePermissionRelationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description: 【 权限表 数据库操作Mapper 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @date : 2020-11-12 13:38:25
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermissionEntity> {

    // ==================== QUERY ====================


    /**
     * 描述: 【 通过ID查询单条数据 】
     *
     * @param id ID
     * @return
     * @author: 摇曳的狗尾巴草
     * @email: "m962464oo@gmail.com"
     * @date: 2020-11-12 13:38:25
     */
    @Select({"<script>" +
            "	SELECT T.* " +
            "   FROM SYS_PERMISSION T " +
            "   WHERE T.ID = #{id}" +
            "</script>"
    })
    SysPermissionDTO queryOneById(@Param("id") Long id);

    @Select("       SELECT\n" +
            "        p.*\n" +
            "        FROM\n" +
            "        sys_user AS u\n" +
            "        LEFT JOIN sys_user_role_relation AS ur\n" +
            "        ON u.id = ur.user_id\n" +
            "        LEFT JOIN sys_role AS r\n" +
            "        ON r.id = ur.role_id\n" +
            "        LEFT JOIN sys_role_permission_relation AS rp\n" +
            "        ON r.id = rp.role_id\n" +
            "        LEFT JOIN sys_permission AS p\n" +
            "        ON p.id = rp.permission_id\n" +
            "        WHERE u.id = #{userId}")
    List<SysPermissionEntity> selectListByUser(@Param("userId") Integer userId);


    @Select("        SELECT" +
            "            pe.*" +
            "        FROM" +
            "            sys_permission pe" +
            "        LEFT JOIN sys_request_path_permission_relation re ON re.permission_id = pe.id" +
            "        LEFT JOIN sys_request_path pa ON pa.id = re.url_id" +
            "        WHERE pa.url = #{path}")
    List<SysPermissionEntity> selectListByPath(String path);


    // ==================== ADD、MODIFY、REMOVE ===================


    // ==================== OTHERS ====================

}
