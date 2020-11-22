package com.test.security.springsecurity.server;

import com.test.security.springsecurity.mapper.SysUserMapper;
import com.test.security.springsecurity.model.entity.SysUserEntity;
import com.test.security.springsecurity.mybatisplus.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Description: 【 用户表 Service接口实现类 】
 *
 * @author : 摇曳的狗尾巴草
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-12 13:38:25
 * @version : 1.0.0
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {


    @Override
    public SysUserEntity selectByName(String userName) {
        return baseMapper.selectByName(userName);
    }

    @Override
    public SysUserEntity saveEntity(SysUserEntity sysUserEntity) {
        save(sysUserEntity);
        return sysUserEntity;
    }
}
