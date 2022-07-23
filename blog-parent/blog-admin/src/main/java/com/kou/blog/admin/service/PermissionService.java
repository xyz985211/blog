package com.kou.blog.admin.service;

import com.kou.blog.admin.entity.Permission;
import com.kou.blog.admin.model.params.PageParam;
import com.kou.blog.admin.vo.Result;

/**
 * @author MiManchi
 * Date: 2022/2/20 10:47
 * Package: com.kou.blog.admin.service
 */
public interface PermissionService {

    /**
     * 权限列表
     */
    Result listPermission(PageParam pageParam);

    /**
     * 增
     */
    Result add(Permission permission);

    /**
     * 更新
     */
    Result update(Permission permission);

    /**
     * 删除
     */
    Result delete(Long id);
}
