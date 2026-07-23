package org.example.springblogdemo.controller;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.example.springblogdemo.pojo.request.UserLoginRequest;
import org.example.springblogdemo.pojo.response.UserInfoResponse;
import org.example.springblogdemo.pojo.response.UserLoginResponse;
import org.example.springblogdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public UserLoginResponse login(@Validated @RequestBody UserLoginRequest request){
        log.info("用户登录, userName:{}", request.getUserName());
        return userInfoService.login(request);
    }

    @GetMapping("/getUserInfo")
    public UserInfoResponse getUserInfo(@NotNull Integer userId){
        log.info("获取用户信息, userId:{}", userId);
        return userInfoService.getUserInfo(userId);
    }

    @GetMapping("/getAuthorInfo")
    public UserInfoResponse getAuthorInfo(@NotNull Integer blogId){
        log.info("获取作者信息, blogId:{}", blogId);
        return userInfoService.getAuthorInfo(blogId);
    }
}

