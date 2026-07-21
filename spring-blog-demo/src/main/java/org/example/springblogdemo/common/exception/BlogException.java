package org.example.springblogdemo.common.exception;

import lombok.Data;
import org.example.springblogdemo.common.enums.ResultCodeEnum;

@Data
public class BlogException extends RuntimeException {
    private Integer code;
    private String errMsg;

    public BlogException(String message) {
        this.code = ResultCodeEnum.FAIL.getCode();
        this.errMsg = message;
    }

    public BlogException(Integer code, String message) {
        this.code = code;
        this.errMsg = message;
    }
}
