package org.example.demo1.model;


import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
