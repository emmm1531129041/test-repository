package mybatisdemo.mapper;

import mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapperXML {

    int insertUser(UserInfo userInfo);

    UserInfo selectUserById(@Param("id") Integer id);

    List<UserInfo> selectAllUsers();

    List<UserInfo> selectUsersByUsername(@Param("username") String username);

    int updateUserById(@Param("username") String username, @Param("id") Integer id);

    int updateUserById2(@Param("userInfo") UserInfo userInfo);

    int deleteUserById(@Param("id") Integer id);

    int deleteUsersByIds(@Param("ids") List<Integer> ids);

    List<UserInfo> selectUsersByCondition(@Param("username") String username,
                                          @Param("minAge") Integer minAge,
                                          @Param("maxAge") Integer maxAge);
}