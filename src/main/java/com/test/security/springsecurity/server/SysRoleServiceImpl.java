package com.test.security.springsecurity.server;

import com.test.security.springsecurity.mapper.SysRoleMapper;
import com.test.security.springsecurity.model.entity.SysRoleEntity;
import com.test.security.springsecurity.mybatisplus.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 【 用户角色表 Service接口实现类 】
 *
 * @author : 摇曳的狗尾巴草
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:24
 * @version : 1.0.0
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {


    @Override
    public List<SysRoleEntity> selectByUser(Integer userId) {
        return baseMapper.selectByUser(userId);
    }
}
