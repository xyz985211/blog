package com.kou.blog.controller;

import com.kou.blog.service.CategoryService;
import com.kou.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaokou
 * @since 2022-01-22
 */
@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result categorys(){
        return categoryService.findAll();
    }

    @GetMapping("/detail")
    public Result categorysDetail(){
        return categoryService.findAllDetail();
    }

    @GetMapping("/detail/{id}")
    public Result categorysDetailById(@PathVariable("id") Long id){
        return categoryService.categorysDetailById(id);
    }
}

