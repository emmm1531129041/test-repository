package mybatisdemo.mapper;

import mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void getList() {
        List<UserInfo> list = userInfoMapper.getList();
        list.stream().forEach(x -> System.out.println(x));
    }

    @Test
    void putList() {
        int result = userInfoMapper.putList(18,"王五","19191919");
        System.out.println(result);
    }

    @Test
    void deleteList() {
        System.out.println(userInfoMapper.deleteList(6));
    }

    @Test
    void updateList(){
        System.out.println(userInfoMapper.updateList(5,"老大"));
    }

    @Test
    void updateAll() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(5);
        userInfo.setAge(99);
        userInfo.setPassword("1414141414");
        userInfo.setUsername("超级无敌大");
        System.out.println(userInfo);
    }

    @Test
    void orderList() {
        List <UserInfo> list = userInfoMapper.orderList();
        list.forEach(x -> System.out.println(x));
    }

    @Test
    void orderList2() {
        List <UserInfo> list = userInfoMapper.orderList2("id");
        list.forEach(              // 1. 遍历list中的每个元素
                System.out::println    // 2. 对每个元素，执行System.out.println
        );
    }
}