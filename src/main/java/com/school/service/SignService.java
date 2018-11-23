package com.school.service;

import com.school.dataobject.Sign;

/**
 * Created by 梁栩菖
 * 2018/11/7 15:29
 */
public interface SignService {
    //签到
    Sign creatSign(Sign sign,String openId,String xopenId);

    //查询签到
    Sign selectSign(String date,int lessionId);
}
