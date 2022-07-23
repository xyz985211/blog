package com.kou.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ms_article_body")
public class ArticleBody implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String content;

    private String contentHtml;

    private Long articleId;


}
