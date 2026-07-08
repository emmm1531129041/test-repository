package mybatisdemo.mapper;

import mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user_info")
    List<UserInfo> getList();

    @Insert("insert * from user_info where #{id}")
    List<UserInfo> putList(Integer id);




}
