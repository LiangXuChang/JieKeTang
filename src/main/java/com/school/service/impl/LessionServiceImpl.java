package com.school.service.impl;

import com.school.dataobject.Lession;
import com.school.repository.LessionRepository;
import com.school.service.LessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 梁栩菖
 * 2018/11/9 14:30
 */
@Service
public class LessionServiceImpl implements LessionService {

    @Autowired
    private LessionRepository lessionRepository;

    /**
     * 学生开始学习某门课程
     * @param lession
     * @return
     */
    public Lession add(Lession lession) {
        lession.setLessonName(lession.getLessonName());
        lession.setStudentId(lession.getStudentId());
        lession.setState(0);
        return lessionRepository.save(lession);
    }

    /**
     * 查询一名学生所有课程
     * @param studentId
     * @return
     */
    public List<Lession> select(int studentId) {
        return lessionRepository.findBystudentId(studentId);
    }

    /**
     * 学生学习完某门课程
     * @return
     */
    public Lession update() {
        return null;
    }


}
