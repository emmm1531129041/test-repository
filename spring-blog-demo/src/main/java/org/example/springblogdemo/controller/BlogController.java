package org.example.springblogdemo.controller;


import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.example.springblogdemo.pojo.request.AddBlogInfoRequest;
import org.example.springblogdemo.pojo.request.UpBlogRequest;
import org.example.springblogdemo.pojo.response.BlogInfoResponse;
import org.example.springblogdemo.service.BlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {

    @Autowired
    private BlogInfoService blogInfoService;

    @GetMapping("/getList")
    public List<BlogInfoResponse> getList(){
        return blogInfoService.getListByDesc();
    }

    @GetMapping("/getBlogDetail")
    public BlogInfoResponse getBlogDetail(@NotNull(message = "blogId 不能为空") Integer blogId){
        log.info("获取博客详情,blogId:{}", blogId);
        return blogInfoService.getBlogDetail(blogId);
    }

    @PostMapping("/add")
    public Boolean addBlog(@Validated @RequestBody AddBlogInfoRequest addBlogInfoRequest){
        log.info("发布博客, blogRequest:{}", addBlogInfoRequest);
        return blogInfoService.addBlog(addBlogInfoRequest);
    }

    @PostMapping("/update")
    public Boolean updateBlog(@Validated @RequestBody UpBlogRequest request){
        log.info("更新博客, blogInfo:{}", request);
        return blogInfoService.updateBlog(request);
    }

    @PostMapping("/delete")
    public Boolean delete(@NotNull(message = "博客ID不能为空") Integer blogId){
        log.info("删除博客, blogId:{}", blogId);
        return blogInfoService.delete(blogId);
    }
}

