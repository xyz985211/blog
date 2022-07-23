package com.kou.blog.common.cache;

import java.lang.annotation.*;

/**
 * @author MiManchi
 * Date: 2022/2/19 19:40
 * Package: com.kou.blog.common.cache
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    //  缓存存在时间
    long expire() default 1 * 60 * 1000;

    //  缓存标识 key
    String name() default "";
}
