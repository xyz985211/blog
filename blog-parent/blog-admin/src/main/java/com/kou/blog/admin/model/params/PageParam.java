package com.kou.blog.admin.model.params;

import lombok.Data;

/**
 * @author MiManchi
 * Date: 2022/2/20 10:37
 * Package: com.kou.blog.admin.model.params
 */
@Data
public class PageParam {

    private Integer currentPage;

    private Integer pageSize;

    private String queryString;

}
