package com.school.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    LOGIN_SUCCESS(0,"登陆成功"),

    LOGIN_ERROR(1,"登陆失败，用户名或密码错误"),

    LOGOUT_SUCCESS(0, "登出成功"),

    DISPLAY_ERROR(1,"对不起您未登陆，请先登陆"),

    WECHAT_MP_ERROR(20, "微信公众账号方面错误"),

    UNKONW_ERROR(-1,"未知错误"),

    SUCCESS(0,"成功"),

//    PRIMARY_SCHOOL(100,"你可能还在上小学"),

//    MIDDLE_SCHOOL(101,"你可能还在上初中"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
