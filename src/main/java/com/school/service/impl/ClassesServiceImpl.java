package com.school.service.impl;

import com.school.dataobject.Classes;
import com.school.repository.ClassesRepository;
import com.school.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesRepository classesRepository;

    /**
     * 创建课程
     * @param openId
     * @param lessonName
     * @param request
     * @return
     */
    public Classes addClass(String openId,String lessonName, HttpServletRequest request){
        Classes classes = new Classes();
        classes.setLessonName(lessonName);
        classes.setOpenId(openId);

        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("file");
        String fileName = multipartFile.getOriginalFilename();

        System.out.println(fileName);

        String realPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file  =  new File(realPath,fileName);
            System.out.println(file);
            multipartFile.transferTo(file);
            String url = "test.socialcontactblog.com/img/"+fileName;
            classes.setLessonImg(url);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        return classesRepository.save(classes);
    }

    /**
     * 上传教程资源
     * @param openId
     * @param lessonId
     * @param request
     * @return
     */
    public Classes uploadFile(String openId,int lessonId,HttpServletRequest request){

        Classes classes = new Classes();

        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("file");
        String fileName = multipartFile.getOriginalFilename();

        System.out.println(fileName);

        String realPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file  =  new File(realPath,fileName);
            System.out.println(file);
            multipartFile.transferTo(file);

            String url = "test.socialcontactblog.com/img/"+fileName;

            return classesRepository.update(url,openId,lessonId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取我上传的课程资料
     * @param openId
     */
    public List<Classes> showAllFile(String openId){
        return classesRepository.findByopenId(openId);
    }

    /**
     * 获取某门课程的所有课程资料
     * @param openId
     * @param lessonId
     * @return
     */
    public Classes showOneFile(String openId,int lessonId){
        return classesRepository.findByOpenIdOrLessonId(openId,lessonId);
    }

}
