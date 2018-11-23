package com.school.exception;

import com.school.enums.ResultEnum;

public class ClassesException extends RuntimeException {
    private Integer code;

    public ClassesException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
