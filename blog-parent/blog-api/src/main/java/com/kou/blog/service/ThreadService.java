package com.kou.blog.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.kou.blog.entity.Article;
import com.kou.blog.mapper.ArticleMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author MiManchi
 * Date: 2022/2/16 9:50
 * Package: com.kou.blog.service
 */
@Component
public class ThreadService {
    /**
     * 期望此操作在线程池执行不会影响原有的主线程
     */
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article) {

        Integer viewCounts = article.getViewCounts();
        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(viewCounts + 1);
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId, article.getId());
        //  设置一个为了在多线程的环境下线程安全
        //  乐观锁，当要修改的数字发生变化时，则不修改
        updateWrapper.eq(Article::getViewCounts, article.getViewCounts());
        //  update article set view_count=100 where view_count=99 and id=11
        articleMapper.update(articleUpdate, updateWrapper);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
