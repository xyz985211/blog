package com.kou.blog.utils;

import com.kou.blog.entity.SysUser;

/**
 * @author MiManchi
 * Date: 2022/2/14 20:32
 * Package: com.kou.blog.utils
 */
public class UserThreadLocal {

    private UserThreadLocal() {}

    private static final ThreadLocal<SysUser> THREAD_LOCAL = new ThreadLocal<>();

    public static void put(SysUser sysUser){
        THREAD_LOCAL.set(sysUser);
    }

    public static SysUser get(){
        return THREAD_LOCAL.get();
    }

    public static void remove(){
        THREAD_LOCAL.remove();
    }
}
