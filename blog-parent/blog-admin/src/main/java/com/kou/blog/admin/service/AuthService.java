package com.kou.blog.admin.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author MiManchi
 * Date: 2022/2/20 11:45
 * Package: com.kou.blog.admin.service
 */
public interface AuthService {

    /**
     * 登录认证
     */
    boolean auth(HttpServletRequest request, Authentication authentication);
}
