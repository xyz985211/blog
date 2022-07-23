package com.kou.blog.admin.service.impl;

import com.kou.blog.admin.entity.Admin;
import com.kou.blog.admin.entity.Permission;
import com.kou.blog.admin.service.AdminService;
import com.kou.blog.admin.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author MiManchi
 * Date: 2022/2/20 11:44
 * Package: com.kou.blog.admin.service.impl
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AdminService adminService;

    @Override
    public boolean auth(HttpServletRequest request, Authentication authentication) {
        //  权限认证
        //  请求路径
        String requestURI = request.getRequestURI();
        //  用户信息
        Object principal = authentication.getPrincipal();
        if (principal == null || "anonymousUser".equals(principal)){
            return false;
        }
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();
        Admin admin = adminService.findAdminByUsername(username);
        if (admin == null){
            return false;
        }
        //  超级管理员
        if (1 == admin.getId()){
            return true;
        }
        Long adminId = admin.getId();
        List<Permission> permissionList = adminService.findPermissionByAdminId(adminId);
        //  路径中可能带有 ? ，需要截取前面的部分
        requestURI = StringUtils.split(requestURI,'?')[0];
        for (Permission permission : permissionList) {
            if (requestURI.equals(permission.getPath())){
                return true;
            }
        }
        return false;
    }
}
