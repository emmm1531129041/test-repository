package org.example.mybatisplusdemo.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("userinfo")
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private Integer age;

    private String email;
}
