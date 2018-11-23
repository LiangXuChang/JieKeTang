package com.school.exception;

import com.school.enums.ResultEnum;

public class StudentException extends RuntimeException {

    private Integer code;

    public StudentException(ResultEnum resultEnum) {
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
