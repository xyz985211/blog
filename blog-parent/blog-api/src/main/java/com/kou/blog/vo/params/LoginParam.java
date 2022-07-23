package com.kou.blog.vo.params;

import lombok.Data;

/**
 * @author MiManchi
 * Date: 2022/2/11 14:42
 * Package: com.kou.blog.vo.params
 */
@Data
public class LoginParam {

    private String account;

    private String password;

    private String nickname;
}
