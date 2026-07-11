package org.example.demo1.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.demo1.model.UserInfo;

@Mapper
public interface UserInfoDao {
    @Select("select * from user_info where user_name = #{user_name} and delete_flag = 0")
    UserInfo queryUserInfoByName(String user_name);
}
