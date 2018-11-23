package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
public class Classes{

    @Id
    @GeneratedValue
    private int lessonId;

    private String openId;

    private String lessonName;

    private String lessonImg;

//    private List<String> file;

}
