package com.kou.blog.service;

import com.kou.blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kou.blog.vo.Result;
import com.kou.blog.vo.params.CommentParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
public interface CommentService extends IService<Comment> {

    /**
     * 根据文章Id查询所有的评论列表
     */
    Result commentsByArticleId(Long id);

    /**
     * 评论功能
     */
    Result comment(CommentParam commentParam);
}
