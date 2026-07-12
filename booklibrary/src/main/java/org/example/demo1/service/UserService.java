package org.example.demo1.service;


import org.example.demo1.dao.UserInfoDao;
import org.example.demo1.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserInfoDao userInfoDao;

    public boolean checkPassword(String name,String password){

        UserInfo userInfo= userInfoDao.queryUserInfoByName(name);
        if(userInfo == null || userInfo.getId() < 1){
            return false;
        }
        return password.equals(userInfo.getPassword());
    }


}
