package com.kou.blog.vo.params;

import lombok.Data;

/**
 * @author MiManchi
 */
@Data
public class CommentParam {

    private Long articleId;

    private String content;

    private Long parent;

    private Long toUserId;
}
