package mybatisdemo.mapper;

import mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user_info")
    List<UserInfo> getList();

    @Insert("insert into user_info (age,username,password) values (#{age},#{username},#{password})")
    int putList(Integer age,String username,String password);

    @Delete("delete from user_info where id = #{id}")
    int deleteList(Integer id);

    @Update("update user_info set username = #{username} where id = #{id}")
    int updateList(Integer id, String username);
    //更新更多内容
    @Update("update user_info set username = #{username}, password = #{password}, age = #{age} WHERE id = #{id}")
    int updateAll(UserInfo userInfo);

    @Select("select * from user_info order by id asc")
    List<UserInfo> orderList();
    //动态传入字符串排序
    @Select("select * from user_info order by ${anything} desc")
    List<UserInfo> orderList2(@Param("anything") String anything);

}