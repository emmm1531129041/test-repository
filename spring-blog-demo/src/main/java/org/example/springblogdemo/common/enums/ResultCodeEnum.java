package org.example.springblogdemo.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(200),
    FAIL(-2),
    UNLOGIN(-1),
    ;
    @Getter
    private int code;
}
