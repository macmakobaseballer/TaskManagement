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

    // ほげほげロジック
    public Task showTask(int taskId) {
        Task task = new Task();
        task.setTaskId(taskId);
        return task;
    }

    // 未完了タスクの一覧取得
    public List<Task> getIncompleteTasks() {
        return taskMapper.selectIncompleteTasks();
    }

    // 未了タスクの一覧取得
    public List<Task> getCompletedTasks() {
        return taskMapper.selectCompletedTasks();
    }

    // タスクの詳細情報取得
    public Task getTaskDetails(int taskId) {
        return taskMapper.selectTask(taskId);
    }

    // 新規タスクの一件登録
    public void registerTask(Task task) {
        taskMapper.insertTask(task);
    }

    // 完了フラグを未完了から完了に更新
    public void updateCompletedFlagToTrue(int taskId) {
        taskMapper.updateCompletedFlagToTrue(taskId);
    }

    // 完了フラグを完了から未完了に更新
    public void updateCompletedFlagToFalse(int taskId) {
        taskMapper.updateCompletedFlagToFalse(taskId);
    }

    // タスクの詳細情報更新（完了フラグ変更なし）
    public void updateTaskDetails(Task task) {
        taskMapper.updateTaskDetailsWithoutCompletedFlag(task);
    }

    // タスク詳細の更新処理（完了フラグ変更あり）
    public void updateTaskAllDetails(Task task) {
        taskMapper.updateTaskDetailsWithCompletedFlag(task);
    }

    // 登録済みタスクの一件削除処理
    public void deleteTask(int taskId) {
        taskMapper.deleteTask(taskId);
    }
}
