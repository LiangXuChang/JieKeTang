package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 梁栩菖
 * 2018/11/7 15:06
 */
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    private int studentId;

    private String openId;

    private String nickName;

    private String avatarUrl;

    private String name;

    private String id;

    private String phone;

    private String sex;

    private String birth;

    //民族
    private String national;

    private String address;
}
