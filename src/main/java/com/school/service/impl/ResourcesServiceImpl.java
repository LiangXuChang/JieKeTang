package com.school.service.impl;

import com.school.dataobject.Resources;
import com.school.repository.ResourcesRepository;
import com.school.service.ResourcesService;
import javax.servlet.http.HttpServletRequest;

import com.school.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;

/**
 * Created by 梁栩菖
 * 2018/11/9 14:40
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private ResourcesRepository resourcesRepository;

    /**
     * 上传课程资源
     * @param lessonId
     * @return
     */
    public Resources uploadFile(int lessonId, @RequestParam("file") MultipartFile file){
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
            String url = "test.socialcontactblog.com/img/"+fileName;
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            System.out.println("文件上传成功");
            Resources resources = new Resources();
            resources.setUrl(url);
            resources.setLessonId(lessonId);
            return resourcesRepository.save(resources);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Resources select(int lessonId) {
        return resourcesRepository.findBylessonId(lessonId);
    }
}
