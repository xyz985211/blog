package com.kou.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kou.blog.entity.SysUser;
import com.kou.blog.mapper.SysUserMapper;
import com.kou.blog.service.LoginService;
import com.kou.blog.service.SysUserService;
import com.kou.blog.utils.JWTUtils;
import com.kou.blog.vo.ErrorCode;
import com.kou.blog.vo.Result;
import com.kou.blog.vo.params.LoginParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author MiManchi
 * Date: 2022/2/11 15:00
 * Package: com.kou.blog.service.impl
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    @Lazy
    private SysUserService sysUserService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 加密盐
     * 为了防止破解MD5算法生成的密码，在密码后面加上加密盐用于强化密码
     */
    private static final String salt = "123456XiaoKou!@#$$";

    @Override
    public Result login(LoginParam loginParam) {

        /**
         * 1. 检查参数是否合法
         * 2. 根据用户名和密码去 user 表中查询是否存在
         * 3. 如果不存在登录失败
         * 4. 如果存在，使用jwt 生成token 返回给前端
         * 5. token放入redis当中， redis token: user信息设置过期时间
         *      (登录认证的时候先认证token字符串是否合法，再去redis认证是否存在)
         */
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();

        //  1.检查参数是否合法
        //  判断账户和密码是否为空
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }

        //  使用MD5算法以及加密盐进行加密
        password = DigestUtils.md5Hex(password + salt);
        SysUser sysUser = sysUserService.findUser(account,password);
        if (sysUser == null){
            //  返回错误码以及错误信息
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(sysUser.getId());
        //  将创建好的token存入redis，并且过期时间为天
        redisTemplate.opsForValue().set("Token_"+token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);

        return Result.success(token);
    }

    @Override
    public SysUser checkToken(String token) {
        if (StringUtils.isBlank(token)){
            return null;
        }
        Map<String, Object> checkToken = JWTUtils.checkToken(token);
        if (checkToken == null){
            return null;
        }
        String userJson = redisTemplate.opsForValue().get("Token_" + token);
        if (StringUtils.isBlank(userJson)){
            return null;
        }
        //  利用fastJson将userJson解析为user对象
        SysUser sysUser = JSON.parseObject(userJson, SysUser.class);

        return sysUser;
    }

    @Override
    public Result logout(String token) {
        redisTemplate.delete("Token_" + token);
        return Result.success(null);
    }

    @Override
    public Result register(LoginParam loginParam) {
        /**
         * 1.判断参数是否合法
         * 2.判断账户是否存在，存在返回账户已经被注册
         * 3.不存在，注册用户
         * 4.生成token
         * 5.存入redis 并返回
         * 6.注意加上事务，一旦中间的任何过程出现问题，注册的用户需要回滚
         */
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        String nickname = loginParam.getNickname();
        if (StringUtils.isBlank(account) ||
            StringUtils.isBlank(password) ||
            StringUtils.isBlank(nickname)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        SysUser sysUser = sysUserService.findUserByAccount(account);
        if (sysUser != null){
            return Result.fail(ErrorCode.ACCOUNT_EXIST.getCode(), ErrorCode.ACCOUNT_EXIST.getMsg());
        }

        sysUser = new SysUser();
        sysUser.setNickname(nickname);
        sysUser.setAccount(account);
        sysUser.setPassword(DigestUtils.md5Hex(password + salt));
        sysUser.setCreateDate(System.currentTimeMillis());
        sysUser.setLastLogin(System.currentTimeMillis());
        sysUser.setAvatar("/static/img/logo.b3a48c0.png");
        //  1 为true
        sysUser.setAdmin(1);
        //  0 为false
        sysUser.setDeleted(0);
        sysUser.setSalt("");
        sysUser.setStatus("");
        sysUser.setEmail("");
        sysUserService.insert(sysUser);

        String token = JWTUtils.createToken(sysUser.getId());

        redisTemplate.opsForValue().set("Token_" + token, JSON.toJSONString(sysUser), 1, TimeUnit.DAYS);

        return Result.success(token);
    }
}
