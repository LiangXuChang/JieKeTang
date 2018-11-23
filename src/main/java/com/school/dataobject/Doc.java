package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 梁栩菖
 * 2018/10/29 11:18
 */
@Data
@Entity
public class Doc {
    //文档ID
    @Id
    @GeneratedValue
    private int docId;

    //设备ID
    private String cId;

    //文档地址
    private String docUrl;
}
