package com.school.repository;

import com.school.dataobject.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:17
 */
public interface TaskRepository extends JpaRepository<Task,Long> {
    public Task findBytaskId(int taskId);
}
