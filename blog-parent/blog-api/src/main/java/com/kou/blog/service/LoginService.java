package com.kou.blog.service;

import com.kou.blog.entity.SysUser;
import com.kou.blog.vo.Result;
import com.kou.blog.vo.params.LoginParam;

/**
 * @author MiManchi
 * Date: 2022/2/11 14:34
 * Package: com.kou.blog.service
 */
public interface LoginService {

    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    /**
     * 检验token
     * @param token
     * @return
     */
    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     * 注册
     * @param loginParam
     * @return
     */
    Result register(LoginParam loginParam);
}
