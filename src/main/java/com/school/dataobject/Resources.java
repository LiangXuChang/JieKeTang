package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 梁栩菖
 * 2018/11/9 14:16
 */
@Entity
@Data
public class Resources {
    @Id
    @GeneratedValue
    private int id;

    private int lessonId;

    private String url;

}
