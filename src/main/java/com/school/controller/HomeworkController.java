package com.school.controller;

import com.school.dataobject.Homework;
import com.school.dataobject.Result;
import com.school.service.HomeworkService;
import com.school.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:39
 */
@RestController
@RequestMapping("/classroom/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @PostMapping("/create")
    public Result<Homework> create(Homework homework,@RequestParam("file") MultipartFile file){
        return ResultUtil.success(homeworkService.create(homework,file));
    }
}
