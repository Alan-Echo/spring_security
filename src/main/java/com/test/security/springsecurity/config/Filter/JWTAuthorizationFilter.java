package com.test.security.springsecurity.config.Filter;



import com.test.security.springsecurity.utils.JwtTokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @description: 鉴权操作
 * @author: ※狗尾巴草
 * @date: 2020-11-14 0:20
 **/
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);

        // 对请求头d的token，进行解析,获取用户权限
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        super.doFilterInternal(request, response, chain);
    }

    // 从token中获取用户权限
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        // token为空或不正确,解析异常
        try {
            String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
            String username = JwtTokenUtils.getUsername(token);
            String roles = JwtTokenUtils.getUserRole(token);
            List<GrantedAuthority> grantedAuthorities  = new ArrayList<>();
            for(String role: roles.split(",")){
                if(StringUtils.isNotBlank(role)){
                    grantedAuthorities.add(new SimpleGrantedAuthority(role));
                }
            }
            if (username != null){
                return new UsernamePasswordAuthenticationToken(username, null,grantedAuthorities);
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }
}

