package com.kou.blog.admin.service.impl;

import com.kou.blog.admin.entity.Admin;
import com.kou.blog.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author MiManchi
 * Date: 2022/2/20 11:28
 * Package: com.kou.blog.admin.service.impl
 */
@Component
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * 登录的时候，会把username 传递到这里
         * 通过username查询admin表，如果admin存在将密码告诉spring security
         * 如果不存在返回null认证失败了
         */
        Admin admin = adminService.findAdminByUsername(username);
        if (admin == null){
            //  登陆失败
            return null;
        }
        UserDetails userDetails = new User(username,admin.getPassword(),new ArrayList<>());
        return userDetails;
    }
}
