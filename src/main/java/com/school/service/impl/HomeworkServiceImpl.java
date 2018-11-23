package com.school.service.impl;

import com.school.dataobject.Homework;
import com.school.repository.HomeworkRepository;
import com.school.service.HomeworkService;
import com.school.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:34
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;

    public Homework create(Homework homework,@RequestParam("file") MultipartFile file) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println(contentType);
        System.out.println(fileName);
        try {
            System.out.println(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("错误");
        }
        String filePath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
        System.out.println(filePath);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            System.out.println("文件上传成功");
            String url = "test.socialcontactblog.com/img/"+fileName;
            homework.setLessonId(homework.getLessonId());
            homework.setStudentId(homework.getStudentId());
            homework.setTaskId(homework.getTaskId());
            homework.setText(homework.getText());
            homework.setFile(url);
            return homeworkRepository.save(homework);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
