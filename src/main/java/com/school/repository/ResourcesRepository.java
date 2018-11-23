package com.school.repository;

import com.school.dataobject.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 梁栩菖
 * 2018/11/9 15:57
 */
public interface ResourcesRepository extends JpaRepository<Resources,Long> {
    public Resources findBylessonId(int lessonId);
}
