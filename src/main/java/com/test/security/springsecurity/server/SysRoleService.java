package com.test.security.springsecurity.server;

import com.test.security.springsecurity.model.entity.SysRoleEntity;
import com.test.security.springsecurity.mybatisplus.BaseService;

import java.util.List;

/**
 * Description: 【 用户角色表 Service接口 】
 *
 * @author : 摇曳的狗尾巴草
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:24
 * @version : 1.0.0
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {


    List<SysRoleEntity> selectByUser(Integer userId);



}
