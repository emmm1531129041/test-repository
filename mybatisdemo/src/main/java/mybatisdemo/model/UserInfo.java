package mybatisdemo.model;


import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private Integer age;
    private Integer gender;
    private String username;
    private String password;
    private String phone;
    private Date createTime;
    private Date updateTime;
}
