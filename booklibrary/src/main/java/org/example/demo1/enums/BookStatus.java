package org.example.demo1.enums;

import lombok.Getter;

@Getter
public enum BookStatus {
    DELETED(0, "无效"),
    NORMAL(1, "可借阅"),
    FORBIDDEN(2, "不可借阅");

    private Integer code;
    private String name;

    BookStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(int code) {
        switch (code) {
            case 0: return DELETED.name;
            case 1: return NORMAL.name;
            case 2: return FORBIDDEN.name;
        }
        return null;
    }

}