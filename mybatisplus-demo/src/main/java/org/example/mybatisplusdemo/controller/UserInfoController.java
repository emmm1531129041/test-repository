package org.example.mybatisplusdemo.controller;

import org.example.mybatisplusdemo.mapper.UserInfoMapper;
import org.example.mybatisplusdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    // 查询所有用户
    @GetMapping("/list")
    public List<UserInfo> list() {
        return userInfoMapper.selectList(null);
    }

    // 添加用户
    @GetMapping("/add")
    public String add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("六六");
        userInfo.setPassword("123456");
        userInfo.setAge(20);
        userInfo.setEmail("zhangsan@qq.com");

        userInfoMapper.insert(userInfo);

        return "添加成功,id=" + userInfo.getId();
    }
}