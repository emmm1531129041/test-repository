package mybatisdemo.mapper;

import mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void getList() {
        List<UserInfo> list = userInfoMapper.getList();
        list.stream().forEach(x -> System.out.println(x));
    }

    @Test
    void putList() {



    }









}