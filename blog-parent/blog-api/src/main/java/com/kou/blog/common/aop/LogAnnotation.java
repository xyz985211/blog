package com.kou.blog.common.aop;

import java.lang.annotation.*;

/**
 * @author MiManchi
 * Date: 2022/2/18 12:36
 * Package: com.kou.blog.common.aop
 */
//Type代表可以放在类上面Method代表可以放在方法上
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    String module() default "";

    String operator() default "";
}
