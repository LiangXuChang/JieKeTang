package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 梁栩菖
 * 2018/11/1 18:31
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private int userId;

//    @Id
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
