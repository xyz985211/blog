package com.kou.blog.controller;

import com.kou.blog.service.TagService;
import com.kou.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    private TagService tagService;

    @GetMapping("/hot")
    public Result hot(){
        Integer limit = 6;
        return tagService.hots(limit);
    }

    @GetMapping
    public Result tags(){
        return tagService.findAll();
    }

    @GetMapping("/detail")
    public Result findAllDetail(){
        return tagService.findAllDetail();
    }

    @GetMapping("/detail/{id}")
    public Result findAllDetailById(@PathVariable("id")Long id){
        return tagService.findAllDetailById(id);
    }
}

