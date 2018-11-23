package com.school.service;

import com.school.dataobject.Classes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ClassesService {

    //创建课程
    Classes addClass(String OpenID,String LessonName,HttpServletRequest request);

    //上传课程资源
    Classes uploadFile(String OpenID,int LessonID,HttpServletRequest request);

    //获取我上传的课程资料
    List<Classes> showAllFile(String OpenID);

    //获取某门课程的所有课程资料
    Classes showOneFile(String OpenID,int LessonID);
}
