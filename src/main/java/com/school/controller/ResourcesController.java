package com.school.controller;

import com.school.dataobject.Resources;
import com.school.dataobject.Result;
import com.school.repository.ResourcesRepository;
import com.school.service.ResourcesService;
import com.school.utils.FileUtil;
import com.school.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by 梁栩菖
 * 2018/11/9 16:02
 */
@RestController
@RequestMapping("/classroom/resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

//    @Autowired
//    private ResourcesRepository resourcesRepository;

    //上传课程资源
    @PostMapping("/creat")
    public Result<Resources> addresources(int lessonId, @RequestParam("file") MultipartFile file){
//        System.out.println("调用creat方法");
        return ResultUtil.success(resourcesService.uploadFile(lessonId,file));
//        String contentType = file.getContentType();
//        String fileName = file.getOriginalFilename();
//        System.out.println(contentType);
//        System.out.println(fileName);
//        try {
//            System.out.println(file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("错误");
//        }
//        String filePath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
//        System.out.println(filePath);
//        try {
//            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
//            System.out.println("文件上传成功");
//            Resources resources = new Resources();
//            resources.setUrl(filePath+fileName);
//            resources.setLessonId(lessonId);
//            return ResultUtil.success(resourcesRepository.save(resources));
//        }catch(Exception e){
//            e.printStackTrace();
//            return null;
//        }
    }

    //查询某个课程的资源
    @GetMapping("/select")
    public Result<Resources> select(int lessonId){
        return ResultUtil.success(resourcesService.select(lessonId));
    }
}
