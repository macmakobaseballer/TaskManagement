package com.raisetech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raisetech.entity.Task;
import com.raisetech.mapper.TaskMapper;

@Service
public class TaskService {

    @Autowired
    TaskMapper taskMapper;
    
    // 未完了タスクの一覧取得
    public List<Task> getTasks() {
    	return taskMapper.selectTasks();
    }

    //一件新規登録
    public void registerTask(Task task){
        taskMapper.insertTask(task);
    }
    
}
