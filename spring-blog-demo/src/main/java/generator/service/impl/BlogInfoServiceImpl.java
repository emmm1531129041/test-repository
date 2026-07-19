package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.BlogInfo;
import generator.service.BlogInfoService;
import generator.mapper.BlogInfoMapper;
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




