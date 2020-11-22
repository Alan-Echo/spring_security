package com.test.security.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.security.springsecurity.model.dto.SysUserDTO;
import com.test.security.springsecurity.model.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Description: 【 用户表 数据库操作Mapper 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @date : 2020-11-12 13:38:25
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

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
            "   FROM SYS_USER T " +
            "   WHERE T.ID = #{id}" +
            "</script>"
    })
    SysUserDTO queryOneById(@Param("id") Long id);

    @Select("select * from SYS_USER where account = #{userName}")
    SysUserEntity selectByName(String userName);

    // ==================== ADD、MODIFY、REMOVE ===================


    // ==================== OTHERS ====================

}
