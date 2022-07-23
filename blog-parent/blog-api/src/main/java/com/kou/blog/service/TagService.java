package com.kou.blog.service;

import com.kou.blog.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kou.blog.vo.Result;
import com.kou.blog.vo.TagVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
public interface TagService extends IService<Tag> {

    List<TagVo> findTagsByArticleId(Long articleId);

    /**
     * 最热标签
     */
    Result hots(Integer limit);

    /**
     * 查询所有的标签
     */
    Result findAll();

    Result findAllDetail();

    Result findAllDetailById(Long id);
}
