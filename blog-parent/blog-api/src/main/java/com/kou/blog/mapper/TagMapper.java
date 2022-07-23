package com.kou.blog.mapper;

import com.kou.blog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 根据文章id查询标签列表
     */
    List<Tag> findTagsByArticleId(Long articleId);

    /**
     * 查询最热的标签 前n条
     */
    List<Long> findHotsTagIds(Integer limit);

    List<Tag> findTagsByTagsId(List<Long> tagIds);
}
