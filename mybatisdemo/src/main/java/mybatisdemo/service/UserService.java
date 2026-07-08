package mybatisdemo.service;

import mybatisdemo.mapper.UserInfoMapper;
import mybatisdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getList(){
        return userInfoMapper.getList();
    }

}
