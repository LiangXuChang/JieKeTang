package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:05
 */
@Data
@Entity
public class Homework {

    @Id
    @GeneratedValue
    private int homeworkId;

    private int studentId;

    private int lessonId;

    private int taskId;

    private String text;

    private String file;
}
