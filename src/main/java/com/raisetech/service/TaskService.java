package com.raisetech.service;

import com.raisetech.entity.Task;
import com.raisetech.mapper.TaskMapper;

import org.springframework.beans.factory.annotation.Autowired;

public class TaskService {

    @Autowired
    TaskMapper taskMapper;

    //一件新規登録
    public void registerTask(Task task){
        taskMapper.insertTask(task);
    }
}
