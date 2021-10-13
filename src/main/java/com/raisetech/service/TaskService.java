package com.raisetech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.raisetech.entity.Task;
import com.raisetech.mapper.TaskMapper;

public class TaskService {

    @Autowired
    TaskMapper taskMapper;
    
    // 未了タスクの一覧取得
    public List<Task> getCompletedTasks() {
    	return taskMapper.selectCompletedTasks();
    }
    
    //一件新規登録
    public void registerTask(Task task){
        taskMapper.insertTask(task);
    }
}
