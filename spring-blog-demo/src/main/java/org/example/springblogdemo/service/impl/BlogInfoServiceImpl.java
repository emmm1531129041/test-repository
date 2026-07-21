package org.example.springblogdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.springblogdemo.pojo.dataobject.BlogInfo;
import generator.service.BlogInfoService;
import org.example.springblogdemo.mapper.BlogInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 张童
* @description 针对表【blog_info(博客表)】的数据库操作Service实现
* @createDate 2026-07-19 17:36:18
*/
@Service
public class BlogInfoServiceImpl extends ServiceImpl<BlogInfoMapper, BlogInfo>
    implements BlogInfoService{

}




