package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:08
 */
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue
    private int taskId;

    private int teacherId;

    private int lessonId;

    private String taskName;

    private String taskTime;
}
