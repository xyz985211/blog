package com.kou.blog.admin.service;

import com.kou.blog.admin.entity.Admin;
import com.kou.blog.admin.entity.Permission;

import java.util.List;

/**
 * @author MiManchi
 * Date: 2022/2/20 11:36
 * Package: com.kou.blog.admin.service
 */
public interface AdminService {


    Admin findAdminByUsername(String username);

    /**
     * 通过adminId查找权限表
     */
    List<Permission> findPermissionByAdminId(Long adminId);
}
