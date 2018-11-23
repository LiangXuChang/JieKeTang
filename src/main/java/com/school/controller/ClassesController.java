package com.school.controller;

import com.school.dataobject.Classes;
import com.school.dataobject.Result;
import com.school.service.ClassesService;
import com.school.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/classroom/classes")
public class ClassesController {

//    private final static Logger logger = LoggerFactory.getLogger(ClassesController.class);

    @Autowired
    private ClassesService classesService;

    /**
     * 创建课程
     */
    @PostMapping("/creat")
    public Result<Classes> classCreat(String OpenID, String LessonName, HttpServletRequest request){
        return ResultUtil.success(classesService.addClass(OpenID,LessonName,request));
    }

    /**
     * 上传课程资源
     */
    @PostMapping("/upload")
    public Result<Classes> classUpload(String OpenID, int LessonID, HttpServletRequest request){
        return ResultUtil.success( classesService.uploadFile(OpenID,LessonID,request));
    }

    /**
     * 获取我上传的课程
     */
    @GetMapping("/getAll")
    public Result<Classes> classGetAll(String OpenID){
        return ResultUtil.success(classesService.showAllFile(OpenID));
    }

    /**
     * 获取某门课程的所有课程资料
     */
    @GetMapping("/getOne")
    public Result<Classes> classGetOne(String OpenID,int LessionID){
        return ResultUtil.success(classesService.showOneFile(OpenID,LessionID));
    }

}
