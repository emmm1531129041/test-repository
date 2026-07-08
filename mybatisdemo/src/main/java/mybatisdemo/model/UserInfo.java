package mybatisdemo.model;


import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer age;
    private Integer gender;
    private String username;
    private String password;
    private String phone;
    private Date create_time;
    private Date update_time;
}
