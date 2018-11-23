package com.school.service;

import com.school.dataobject.Student;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

/**
 * Created by 梁栩菖
 * 2018/11/7 15:47
 */
public interface StudentService {
    //创建学生
    public Student addStudent(Student student);

    //查询学生
    public Student selectStudent(String openid);

    //学生完善身份信息
    public Student updateStudent(HttpServletRequest request, String phone, String openid, String avatarUrl, String nickname, int studentId);
}
