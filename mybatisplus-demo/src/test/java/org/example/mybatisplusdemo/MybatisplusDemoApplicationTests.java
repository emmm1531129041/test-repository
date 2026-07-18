package org.example.mybatisplusdemo;

import org.example.mybatisplusdemo.mapper.UserInfoMapper;
import org.example.mybatisplusdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusDemoApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testSelectById() {
        UserInfo userInfo = userInfoMapper.selectById(1L);
        System.out.println(userInfo);
    }

}
