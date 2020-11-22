package com.test.security.springsecurity.server;


import com.baomidou.mybatisplus.extension.service.IService;
import com.test.security.springsecurity.model.entity.SysPermissionEntity;
import com.test.security.springsecurity.model.entity.SysRolePermissionRelationEntity;
import com.test.security.springsecurity.mybatisplus.BaseService;

import java.util.List;

/**
 * Description: 【 权限表 Service接口 】
 *
 * @author : 摇曳的狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:25
 */
public interface SysPermissionService extends BaseService<SysPermissionEntity> {

    /**
     * 查询用户的权限列表
     *
     * @param userId
     * @return
     */
    List<SysPermissionEntity> selectListByUser(Integer userId);


    List<SysPermissionEntity> selectListByPath(String path);
}
