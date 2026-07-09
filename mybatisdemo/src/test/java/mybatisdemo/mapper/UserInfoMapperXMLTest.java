package mybatisdemo.mapper;

import mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserInfoMapperXMLTest {

    @Autowired
    private UserInfoMapperXML userInfoMapperXML;

    @Test
    void testInsertUser() {
        UserInfo user = new UserInfo();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setAge(25);
        int result = userInfoMapperXML.insertUser(user);
        System.out.println("插入结果：" + result + "，生成ID：" + user.getId());
    }

    @Test
    void testSelectUserById() {
        UserInfo user = userInfoMapperXML.selectUserById(1);
        System.out.println("查询结果：" + user);
    }

    @Test
    void testSelectAllUsers() {
        List<UserInfo> list = userInfoMapperXML.selectAllUsers();
        list.forEach(System.out::println);
    }

    @Test
    void testSelectUsersByUsername() {
        List<UserInfo> list = userInfoMapperXML.selectUsersByUsername("张");
        list.forEach(System.out::println);
    }

    @Test
    void testUpdateUserById() {
        int result = userInfoMapperXML.updateUserById("李四", 1);
        System.out.println("更新结果：" + result);
    }

    @Test
    void testUpdateUserById2() {
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setUsername("王五");
        user.setAge(30);
        int result = userInfoMapperXML.updateUserById2(user);
        System.out.println("更新结果：" + result);
    }

    @Test
    void testDeleteUserById() {
        int result = userInfoMapperXML.deleteUserById(1);
        System.out.println("删除结果：" + result);
    }

    @Test
    void testDeleteUsersByIds() {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        int result = userInfoMapperXML.deleteUsersByIds(ids);
        System.out.println("批量删除结果：" + result);
    }

    @Test
    void testSelectUsersByCondition() {
        List<UserInfo> list = userInfoMapperXML.selectUsersByCondition("张", 20, 30);
        list.forEach(System.out::println);
    }
}