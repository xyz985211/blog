package com.kou.blog.controller;

import com.kou.blog.common.aop.LogAnnotation;
import com.kou.blog.common.cache.Cache;
import com.kou.blog.service.ArticleService;
import com.kou.blog.vo.Result;
import com.kou.blog.vo.params.ArticleParam;
import com.kou.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaokou
 * @since 2022-01-22
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 首页文章列表
     * 加上此注解代表要对此接口记录日志
     */
    @LogAnnotation(module = "文章", operator = "获取文章列表")
    @PostMapping
    @Cache(expire = 5 * 60 * 1000,name = "listArticle")
    public Result listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }

    /**
     * 首页最热文章
     */
    @PostMapping("/hot")
    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
    public Result hotArticle(){
        Integer limit = 3;
        return articleService.hotArticle(limit);
    }

    /**
     * 首页最新文章
     */
    @PostMapping("/new")
    @Cache(expire = 5 * 60 * 1000,name = "new_article")
    public Result newArticles(){
        Integer limit = 3;
        return articleService.newArticle(limit);
    }

    /**
     * 文章归档
     */
    @PostMapping("/listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }

    /**
     * 文章详情
     */
    @PostMapping("/view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }

    /**
     * 文章发布
     */
    @PostMapping("/publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }
}

