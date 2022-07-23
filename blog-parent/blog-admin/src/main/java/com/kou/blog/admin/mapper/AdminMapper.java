package com.kou.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kou.blog.admin.entity.Admin;
import com.kou.blog.admin.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author MiManchi
 * Date: 2022/2/20 11:37
 * Package: com.kou.blog.admin.mapper
 */
public interface AdminMapper extends BaseMapper<Admin> {

    @Select("SELECT * FROM ms_permission where id in (SELECT permission_id FROM ms_admin_permission where admin_id = #{adminId})")
    List<Permission> findPermissionByAdminId(Long adminId);
}
