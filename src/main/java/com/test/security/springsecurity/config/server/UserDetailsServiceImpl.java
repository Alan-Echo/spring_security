package com.test.security.springsecurity.config.server;

import com.test.security.springsecurity.model.entity.SysPermissionEntity;
import com.test.security.springsecurity.model.entity.SysRoleEntity;
import com.test.security.springsecurity.model.entity.SysUserEntity;
import com.test.security.springsecurity.server.SysPermissionService;
import com.test.security.springsecurity.server.SysRoleService;
import com.test.security.springsecurity.server.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 说明
 * @author: ※狗尾巴草
 * @date: 2020-11-13 10:00
 **/
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Autowired
    private SysRoleService sysRoleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //需要构造出 org.springframework.security.core.userdetails.User 对象并返回
        //校验验证码等操作....
        //
        if(!StringUtils.isNotBlank(username)){
            throw new RuntimeException("用户不能为空");
        }
        SysUserEntity userEntity = sysUserService.selectByName(username);
        if(userEntity==null){
            throw new RuntimeException("用户不存在");
        }
        List<GrantedAuthority> grantedAuthorities  = new ArrayList<>();
        //获取该用户所拥有的权限
        List<SysPermissionEntity> permissionList = sysPermissionService.selectListByUser(userEntity.getId());


        //角色和权限共用GrantedAuthority接口，唯一的不同角色就是多了个前缀"ROLE_"
        // 声明用户授权
        permissionList.forEach(permission ->{
            //基于权限控制
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermission_code()));
        });

        //获取用户所有角色
//        List<SysRoleEntity> roleList = sysRoleService.selectByUser(userEntity.getId());

////        // 声明用户角色
//        roleList.forEach(role ->{
//            //基于角色控制
//            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole_code()));
//        });

        User user = new User(userEntity.getAccount(), userEntity.getPassword(), userEntity.getEnabled() == 1, userEntity.getAccount_not_expired() == 1, userEntity.getCredentials_not_expired() == 1, userEntity.getAccount_not_locked() == 1, grantedAuthorities);
        return user;
    }

}

