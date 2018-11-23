package com.school.controller;

import com.school.dataobject.Result;
import com.school.dataobject.Sign;
import com.school.service.SignService;
import com.school.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 梁栩菖
 * 2018/11/7 15:43
 */
@RestController
@RequestMapping("/classroom/sign")
public class SignController {

    @Autowired
    private SignService signService;

    /**
     * 签到
     */
    @GetMapping("/creat")
    public Result<Sign> creatSign(Sign sign,String openId,String xopenId){
        return ResultUtil.success(signService.creatSign(sign,openId,xopenId));
    }

    /**
     * 查询签到
     */
    @GetMapping("/select")
    public Result<Sign> selectSign(String date,int lessionId){
        return ResultUtil.success(signService.selectSign(date,lessionId));
    }
}
