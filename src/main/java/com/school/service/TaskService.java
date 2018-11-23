package com.school.service;

import com.school.dataobject.Task;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:15
 */
public interface TaskService {
    //分发任务
    public Task creat(Task task);

    //任务情况统计
    public Task select(int taskId);
}
