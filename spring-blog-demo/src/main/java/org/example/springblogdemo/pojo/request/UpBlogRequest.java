package org.example.springblogdemo.pojo.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpBlogRequest {
    @NotNull(message = "博客ID不能为空")
    @Min(1)
    private Integer id;
    private String title;
    private String content;
}

