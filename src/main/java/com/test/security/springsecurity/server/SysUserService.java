package com.test.security.springsecurity.server;

import com.test.security.springsecurity.model.entity.SysUserEntity;
import com.test.security.springsecurity.mybatisplus.BaseService;

/**
 * Description: 【 用户表 Service接口 】
 *
 * @author : 摇曳的狗尾巴草
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:25
 * @version : 1.0.0
 */
public interface SysUserService extends BaseService<SysUserEntity> {
    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    SysUserEntity selectByName(String userName);

    SysUserEntity saveEntity(SysUserEntity sysUserEntity);

}
