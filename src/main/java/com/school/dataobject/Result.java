package com.school.dataobject;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    //鼠标按键5，大拇指上方按键，作用:序列化的时候可以有一个ID保证唯一
    private static final long serialVersionUID = 6132308046479825531L;


    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体的内容*/
    private T data;

}
