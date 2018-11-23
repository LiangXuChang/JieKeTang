package com.school.service;

import com.school.dataobject.Homework;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:30
 */
public interface HomeworkService {

    //提交任务
    public Homework create(Homework homework,@RequestParam("file") MultipartFile file);
}
