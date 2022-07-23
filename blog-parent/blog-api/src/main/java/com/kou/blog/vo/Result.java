package com.kou.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author MiManchi
 * Date: 2022/1/22 20:41
 * Package: com.kou.blog.vo
 */
@Data
@AllArgsConstructor
public class Result {

    private boolean success;

    private Integer code;

    private String msg;

    private Object data;

    public static Result success(Object data){
        return new Result(true,200,"success",data);
    }

    public static Result fail(Integer code, String msg){
        return new Result(false, code, msg ,null);
    }
}
