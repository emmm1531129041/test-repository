package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.UserInfo;
import generator.service.UserInfoService;
import generator.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 张童
* @description 针对表【user_info(用户表)】的数据库操作Service实现
* @createDate 2026-07-19 17:36:18
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




