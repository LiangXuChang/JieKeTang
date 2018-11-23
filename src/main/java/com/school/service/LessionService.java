package com.school.service;

import com.school.dataobject.Lession;

import java.util.List;

/**
 * Created by 梁栩菖
 * 2018/11/9 14:30
 */
public interface LessionService {
    //学生学习课程
    Lession add(Lession lession);
    //查询学生所学习的课程
    List<Lession> select(int studentId);
    //学生完成所学习的课程
    Lession update();
}
