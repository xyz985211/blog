package com.kou.blog.controller;

import com.kou.blog.utils.QiniuUtils;
import com.kou.blog.vo.ErrorCode;
import com.kou.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author MiManchi
 * Date: 2022/2/19 10:27
 * Package: com.kou.blog.controller
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private QiniuUtils qiniuUtils;

    @PostMapping
    public Result upload(@RequestParam("image") MultipartFile file){
        //  原始文件名称  比如:aa.png
        String originalFilename = file.getOriginalFilename();
        /**
         * 唯一的文件名称
         * substringAfterLast的作用是将originalFilename的字符.后面的字符拿到，即就是png
         * 文件名称  UUID.文件后缀
         */
        String fileName = UUID.randomUUID().toString() + "." +
                StringUtils.substringAfterLast(originalFilename, ".");
        //上传文件. 上传到哪呢? 七牛云云服务器按量付费速度快把图片发放到离用户最近的服务器上
        //降低我们自身应用服务器的带宽消耗
        boolean upload = qiniuUtils.upload(file, fileName);
        if (upload){
            return Result.success("http://" + QiniuUtils.url + "/" + fileName);
        }
        return Result.fail(20001, "上传失败");
    }
}
