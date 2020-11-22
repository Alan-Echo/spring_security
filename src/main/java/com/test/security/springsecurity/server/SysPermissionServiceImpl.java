package com.test.security.springsecurity.server;

import com.test.security.springsecurity.mapper.SysPermissionMapper;
import com.test.security.springsecurity.model.entity.SysPermissionEntity;
import com.test.security.springsecurity.model.entity.SysRolePermissionRelationEntity;
import com.test.security.springsecurity.mybatisplus.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 【 权限表 Service接口实现类 】
 *
 * @author : 摇曳的狗尾巴草
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:25
 * @version : 1.0.0
 */
@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermissionMapper,SysPermissionEntity> implements SysPermissionService {


    @Override
    public List<SysPermissionEntity> selectListByUser(Integer userId) {
        return baseMapper.selectListByUser(userId);
    }

    @Override
    public List<SysPermissionEntity> selectListByPath(String path) {
        return baseMapper.selectListByPath(path);
    }


}
