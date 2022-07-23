package com.kou.blog.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * @author MiManchi
 * Date: 2022/2/20 10:54
 * Package: com.kou.blog.admin.vo
 */
@Data
public class PageResult<T> {

    private List<T> list;

    private Long total;
}
