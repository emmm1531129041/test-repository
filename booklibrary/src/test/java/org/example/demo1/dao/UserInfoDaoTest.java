package org.example.demo1.dao;

import org.example.demo1.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class UserInfoDaoTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    void queryUserInfoByName() {
        String name = "zhangsan";
        UserInfo userInfo= userInfoDao.queryUserInfoByName(name);
        System.out.println(userInfo);
    }
}