package com.kou.blog.service;

import com.kou.blog.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kou.blog.vo.Result;
import com.kou.blog.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
public interface SysUserService extends IService<SysUser> {

    SysUser findUserById(Long authorId);

    SysUser findUser(String account, String password);

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);

    /**
     * 根据账户查找用户
     * @param account
     * @return
     */
    SysUser findUserByAccount(String account);

    /**
     * 注册
     * @param sysUser
     */
    void insert(SysUser sysUser);

    UserVo findUserVoById(Long id);
}
