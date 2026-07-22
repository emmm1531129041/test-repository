package org.example.springblogdemo.pojo.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class BlogInfoResponse {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime updateTime;

    /**
     * 列表页需要对content 字段处理
     * @return
     */
//    public String getContent() {
//        return StringUtils.hasText(content)?content.substring(0,100): "";
//    }
}
