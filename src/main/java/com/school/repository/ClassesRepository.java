package com.school.repository;

import com.school.dataobject.Classes;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassesRepository extends JpaRepository<Classes,Long> {
//    Classes findByOpenID(String openid);

//    public Classes findByLessonID(String OpenID,int LessonID);

//    @Transactional
//    @Query(value="UPDATE classes xe SET xe.LessonImg = :date WHERE xe.OpenID = :OpenID AND xe.LessonID = :LessonID")
//    Classes update(@Param("LessonImg")String LessonImg,@Param("OpenID")String OpenID,@Param("LessonID")int LessonID);
    public List<Classes> findByopenId(String openid);

    public Classes findByOpenIdOrLessonId(String openid,int lessonid);

    @Modifying
    @Transactional
    @Query(value="UPDATE Classes xe SET xe.lessonImg = :lessonImg WHERE xe.openId = :openId AND xe.lessonId = :lessonId")
    Classes update(@Param("lessonImg")String lessonImg, @Param("openId")String openId, @Param("lessonId")int lessonId);
}
