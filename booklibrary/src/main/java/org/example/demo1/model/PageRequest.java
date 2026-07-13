package org.example.demo1.model;

import lombok.Data;

@Data
public class PageRequest {
    // 当前页
    private Integer currentPage = 1;  // 默认第1页
    // 每页个数
    private Integer pageSize = 10;    // 默认每页10条

    private int offset;  // 偏移量（可能不需要这个字段）

    // 通过getter方法动态计算偏移量
    public int getOffset() {
        return (currentPage - 1) * pageSize;
    }
}
