package com.school.service;

import com.school.dataobject.Resources;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by 梁栩菖
 * 2018/11/9 14:39
 */
public interface ResourcesService {
    //上传文件
    Resources uploadFile(int lessonId, @RequestParam("file") MultipartFile file);
    //根据lessionId查询课程资料
    Resources select(int lessonId);
}
