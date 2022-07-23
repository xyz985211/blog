package com.kou.blog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kou.blog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kou.blog.mapper.dos.Archives;
import com.kou.blog.vo.Result;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 文章归档
     */
    List<Archives> listArchives();

    /**
     * 分页以及文章归档
     */
    IPage<Article> listArticle(Page<Article> page, Long categoryId, Long tagId, String year, String month);
}
