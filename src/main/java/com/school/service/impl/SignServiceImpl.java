package com.school.service.impl;

import com.school.dataobject.Sign;
import com.school.repository.SignRepository;
import com.school.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 梁栩菖
 * 2018/11/7 15:29
 */
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private SignRepository signRepository;

    //签到
    public Sign creatSign(Sign sign,String openId,String xopenId){
        if(openId.equals(xopenId)){
            sign.setDate(sign.getDate());
            sign.setLessonId(sign.getLessonId());
            sign.setStudentId(sign.getStudentId());
            sign.setTime(sign.getTime());
            sign.setSheBeiId(sign.getSheBeiId());
            sign.setUserId(sign.getUserId());
            return signRepository.save(sign);
        }else {
            return null;
        }

    }

    //查询签到
    public Sign selectSign(String date,int lessionId){
        return signRepository.findByDateOrLessonId(date,lessionId);
    }
}
