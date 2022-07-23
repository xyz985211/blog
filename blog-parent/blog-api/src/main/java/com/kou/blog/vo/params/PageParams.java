package com.kou.blog.vo.params;

import lombok.Data;

/**
 * Created by MiManchi
 * Date: 2022/1/22 20:12
 * Package: com.kou.blog.vo.params
 */
@Data
public class PageParams {

    private Integer pageNo = 1;

    private Integer pageSize = 10;

    private Long categoryId;

    private Long tagId;

    private String year;

    private String month;

    public String getMonth(){
        if (this.month != null && this.month.length() == 1){
            return "0"+this.month;
        }
        return this.month;
    }
}
