package org.example.demo1.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public boolean login(String name,String password){
        //参数校验
        if(!StringUtils.hasText(name) || !StringUtils.hasText(password)){
            log.warn("登录失败：用户名或密码为空");
            return false;
        }
//        if("admin".equals(name) && "123456".equals(password)){
//            return true;
//        }
//        return false;
        boolean result = userService.checkPassword(name,password);
        if(!result){
            log.warn("登录失败：用户名或密码错误，用户名：{}", name);
        }
        return result;
    }
}
