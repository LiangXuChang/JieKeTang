package com.school.service.impl;

import com.school.dataobject.Task;
import com.school.repository.TaskRepository;
import com.school.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:16
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task creat(Task task) {
        task.setLessonId(task.getLessonId());
        task.setTaskName(task.getTaskName());
        task.setTaskTime(task.getTaskTime());
        task.setTeacherId(task.getTeacherId());
        return taskRepository.save(task);
    }


    public Task select(int taskId) {
        return taskRepository.findBytaskId(taskId);
    }
}
