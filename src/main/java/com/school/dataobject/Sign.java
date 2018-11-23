package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 梁栩菖
 * 2018/11/7 15:21
 */
@Entity
@Data
public class Sign {
    @Id
    @GeneratedValue
    private int id;

    //开课时间
    private String date;

    private int studentId;

    private int userId;

    private int lessonId;

    private String sheBeiId;

    //签到的当前时间
    private String time;
}
