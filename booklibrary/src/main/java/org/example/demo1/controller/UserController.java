package org.example.demo1.controller;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public boolean login(String name,String password){
        //参数校验
        if(!StringUtils.hasText(name) || !StringUtils.hasText(password)){
            return false;
        }
        if("admin".equals(name) && "123456".equals(password)){
            return true;
        }
        return false;
    }
}
