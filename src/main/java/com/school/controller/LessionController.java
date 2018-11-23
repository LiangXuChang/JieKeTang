package com.school.controller;

import com.school.dataobject.Lession;
import com.school.dataobject.Result;
import com.school.service.LessionService;
import com.school.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 梁栩菖
 * 2018/11/9 16:25
 */
@RestController
@RequestMapping("/classroom/lession")
public class LessionController {
    @Autowired
    private LessionService lessionService;

    /**
     * 学生学习某门课程
     * @param lession
     * @return
     */
    @GetMapping("/add")
    public Result<Lession> add(Lession lession){
        return ResultUtil.success(lessionService.add(lession));
    }

    /**
     * 查看学生所有课程
     * @param studentId
     * @return
     */
    public Result<Lession> select(int studentId){
        return ResultUtil.success(lessionService.select(studentId));
    }
}
