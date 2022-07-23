package com.kou.blog.handler;

/**
 * @author MiManchi
 * Date: 2022/2/10 9:38
 * Package: com.kou.blog.handler
 */

import com.kou.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 对加了@Controller注解的方法进行拦截处理AOP的实现
 * @author MiManchi
 */
@ControllerAdvice
public class AllExceptionHandler {

    /**
     * 进行异常处理，处理Exception.class的异常
     * 返回json
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception e){
        e.printStackTrace();
        return Result.fail(-999,"系统异常");
    }
}
