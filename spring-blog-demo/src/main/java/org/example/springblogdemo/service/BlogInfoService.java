package org.example.springblogdemo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.validation.constraints.NotNull;
import org.example.springblogdemo.pojo.dataobject.BlogInfo;
import org.example.springblogdemo.pojo.request.AddBlogInfoRequest;
import org.example.springblogdemo.pojo.request.UpBlogRequest;
import org.example.springblogdemo.pojo.response.BlogInfoResponse;

import java.util.List;

/**
 * @author lucf
 * @description 针对表【blog_info(博客表)】的数据库操作Service
 * @createDate 2026-05-09 21:16:44
 */
public interface BlogInfoService extends IService<BlogInfo> {

    List<BlogInfoResponse> getListByDesc();

    BlogInfoResponse getBlogDetail(Integer blogId);

    Boolean addBlog(AddBlogInfoRequest addBlogInfoRequest);

    Boolean updateBlog(UpBlogRequest request);

    Boolean delete(@NotNull(message = "博客ID不能为空") Integer blogId);
}
