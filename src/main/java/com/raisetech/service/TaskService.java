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
    public List<Task> getIncompleteTasks() {
    	return taskMapper.selectIncompleteTasks();
    }
  
    // 未了タスクの一覧取得
    public List<Task> getCompletedTasks() {
    	return taskMapper.selectCompletedTasks();
    }
    
    public Task getTaskDetails(int taskId){
        return taskMapper.selectTask(taskId);
    }
  
    //一件新規登録
    public void registerTask(Task task){
        taskMapper.insertTask(task);
    }
    
}
