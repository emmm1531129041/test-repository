package org.example.springblogdemo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.validation.constraints.NotNull;
import org.example.springblogdemo.pojo.dataobject.UserInfo;
import org.example.springblogdemo.pojo.request.UserLoginRequest;
import org.example.springblogdemo.pojo.response.UserInfoResponse;
import org.example.springblogdemo.pojo.response.UserLoginResponse;

/**
 * @author lucf
 * @description 针对表【user_info(用户表)】的数据库操作Service
 * @createDate 2026-05-09 21:16:44
 */
public interface UserInfoService extends IService<UserInfo> {

    UserLoginResponse login(UserLoginRequest request);

    UserInfoResponse getUserInfo(@NotNull Integer userId);

    UserInfoResponse getAuthorInfo(@NotNull Integer blogId);
}

