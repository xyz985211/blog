package com.kou.blog.service;

import com.kou.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kou.blog.vo.Result;
import com.kou.blog.vo.params.ArticleParam;
import com.kou.blog.vo.params.PageParams;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页查询，文章列表
     */
    Result listArticle(PageParams pageParams);

    /**
     * 最热文章
     */
    Result hotArticle(Integer limit);

    /**
     * 最新文章
     */
    Result newArticle(Integer limit);

    /**
     * 文章归档
     */
    Result listArchives();

    /**
     * 文章详情
     */
    Result findArticleById(Long articleId);

    /**
     * 文章发布服务
     */
    Result publish(ArticleParam articleParam);
}
