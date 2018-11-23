package com.school.repository;

import com.school.dataobject.Sign;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 梁栩菖
 * 2018/11/7 15:26
 */
public interface SignRepository extends JpaRepository<Sign,Integer> {
    public Sign findByDateOrLessonId(String date,int lessonid);
}
