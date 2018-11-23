package com.school.controller;

import com.school.dataobject.Result;
import com.school.dataobject.User;
import com.school.service.StudentService;
import com.school.utils.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by 梁栩菖
 * 2018/11/7 15:59
 */
@CrossOrigin
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 学生
     * 微信小程序完善身份信息
     * @param request
     * @param phone
     * @param openid
     * @param avatarUrl
     * @param nickname
     * @param userId
     * @return
     */
    @RequestMapping(value="/classroom/student/idcard", method = RequestMethod.POST)
    public Result<User> uploadPicture(HttpServletRequest request, String phone, String openid, String avatarUrl, String nickname, int userId){
        return ResultUtil.success(studentService.updateStudent(request,phone,openid,avatarUrl,nickname,userId));

    }

}
