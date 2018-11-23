package com.school.controller;

import com.school.dataobject.Result;
import com.school.dataobject.Task;
import com.school.service.TaskService;
import com.school.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 梁栩菖
 * 2018/11/12 18:23
 */
@RestController
@RequestMapping("/classroom/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/create")
    public Result<Task> creat(Task task){
        return ResultUtil.success(taskService.creat(task));
    }

    @GetMapping("/select")
    public Result<Task> select(int taskId){
        return ResultUtil.success(taskService.select(taskId));
    }
}
