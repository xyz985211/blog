package com.kou.blog.controller;

import com.kou.blog.service.LoginService;
import com.kou.blog.vo.Result;
import com.kou.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MiManchi
 * Date: 2022/2/11 14:32
 * Package: com.kou.blog.controller
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("")
    public Result login(@RequestBody LoginParam loginParam){
        //登录验证用户 访问用户表，但是
        return loginService.login(loginParam);
    }

}
