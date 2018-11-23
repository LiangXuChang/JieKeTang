package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 梁栩菖
 * 2018/11/7 10:39
 */
@Entity
@Data
public class Lession {
    @Id
    @GeneratedValue
    private int id;

    private int studentId;

    private String lessonName;

    private int state;

}
