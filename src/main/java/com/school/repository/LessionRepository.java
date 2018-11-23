package com.school.repository;

import com.school.dataobject.Lession;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 梁栩菖
 * 2018/11/7 10:40
 */
public interface LessionRepository extends JpaRepository<Lession,Long> {
    public List<Lession> findBystudentId(int studentId);
//
//    public Lession findByOpenIdOrLessonId(String openid,int lessonid);
//
//    @Modifying
//    @Transactional
//    @Query(value="UPDATE Lession xe SET xe.lessonImg = :lessonImg WHERE xe.openId = :openId AND xe.lessonId = :lessonId")
//    Lession update(@Param("lessonImg")String lessonImg, @Param("openId")String openId, @Param("lessonId")int lessonId);
}
