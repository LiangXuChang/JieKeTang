package com.school.repository;

import com.school.dataobject.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 梁栩菖
 * 2018/11/7 15:10
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Student findByopenId(String openid);
}
