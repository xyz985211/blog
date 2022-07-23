package com.kou.blog.service;

import com.kou.blog.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kou.blog.vo.CategoryVo;
import com.kou.blog.vo.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
public interface CategoryService extends IService<Category> {

    /**
     * 文章类别
     */
    CategoryVo findCategoryById(Long categoryId);

    /**
     * 查询所有类别
     */
    Result findAll();

    Result findAllDetail();

    Result categorysDetailById(Long id);
}
