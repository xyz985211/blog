package com.kou.blog.controller;

import com.kou.blog.entity.SysUser;
import com.kou.blog.utils.UserThreadLocal;
import com.kou.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MiManchi
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}
