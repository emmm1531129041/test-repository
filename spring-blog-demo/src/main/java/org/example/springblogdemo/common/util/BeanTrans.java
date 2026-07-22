package org.example.springblogdemo.common.util;
import org.example.springblogdemo.common.exception.BlogException;
import org.example.springblogdemo.pojo.dataobject.BlogInfo;
import org.example.springblogdemo.pojo.dataobject.UserInfo;
import org.example.springblogdemo.pojo.request.AddBlogInfoRequest;
import org.example.springblogdemo.pojo.request.UpBlogRequest;
import org.example.springblogdemo.pojo.response.BlogInfoResponse;
import org.example.springblogdemo.pojo.response.UserInfoResponse;
import org.springframework.beans.BeanUtils;

public class BeanTrans {

    public static BlogInfoResponse trans(BlogInfo blogInfo){
        if (blogInfo==null){
            throw new BlogException("博客信息不能为空");
        }
        BlogInfoResponse blogInfoResponse = new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfo,blogInfoResponse);
        return blogInfoResponse;
    }

    public static UserInfoResponse trans(UserInfo userInfo){
        if (userInfo==null){
            return null;
        }
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        BeanUtils.copyProperties(userInfo, userInfoResponse);
        return userInfoResponse;
    }

    public static BlogInfo trans(AddBlogInfoRequest addBlogInfo){
        if (addBlogInfo==null){
            return null;
        }
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(addBlogInfo, blogInfo);
        return blogInfo;
    }

    public static BlogInfo trans(UpBlogRequest updateBlog){
        if (updateBlog==null){
            return null;
        }
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(updateBlog, blogInfo);
        return blogInfo;
    }
}
