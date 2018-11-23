package com.school.repository;

import com.school.dataobject.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:34
 */
public interface HomeworkRepository extends JpaRepository<Homework,Long> {

}
