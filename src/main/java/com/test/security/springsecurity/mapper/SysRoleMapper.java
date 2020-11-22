package com.test.security.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.security.springsecurity.model.dto.SysRoleDTO;
import com.test.security.springsecurity.model.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description: 【 用户角色表 数据库操作Mapper 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @date : 2020-11-12 13:38:24
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

    // ==================== QUERY ====================


    /**
     * 描述: 【 通过ID查询单条数据 】
     *
     * @param id ID
     * @return
     * @author: 摇曳的狗尾巴草
     * @email: "m962464oo@gmail.com"
     * @date: 2020-11-12 13:38:24
     */
    @Select({"<script>" +
            "	SELECT T.* " +
            "   FROM SYS_ROLE T " +
            "   WHERE T.ID = #{id}" +
            "</script>"
    })
    SysRoleDTO queryOneById(@Param("id") Long id);

    @Select("select r.* from sys_role r LEFT JOIN sys_user_role_relation ur on ur.user_id=r.id where ur.user_id = #{userId}")
    List<SysRoleEntity> selectByUser(Integer userId);

    // ==================== ADD、MODIFY、REMOVE ===================


    // ==================== OTHERS ====================

}
