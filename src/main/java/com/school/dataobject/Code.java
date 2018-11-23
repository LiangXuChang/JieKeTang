package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 梁栩菖
 * 2018/10/29 11:24
 */
@Data
@Entity
public class Code {
    //二维码ID
    @Id
    @GeneratedValue
    private int codeId;

    //设备ID
    private String cId;

    //二维码地址
    private String codeUrl;
}
