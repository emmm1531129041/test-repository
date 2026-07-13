package org.example.demo1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor   // 自动生成无参构造
@AllArgsConstructor  // 自动生成全参构造
@Data
public class PageResponse<T> {
    private Integer total;
    private List<T> records;

//    // 无参构造
//    public PageResponse() {}
//
//    // 有参构造（简化版使用这个）
//    public PageResponse(Integer total, List<T> records) {
//        this.total = total;
//        this.records = records;
//    }

}
