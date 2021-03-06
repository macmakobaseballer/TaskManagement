package com.raisetech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.raisetech.entity.Task;

@Mapper
public interface TaskMapper {
    
    // 未完了タスクの一覧取得
    List<Task> selectIncompleteTasks();
    
    // 完了タスクの一覧取得
    List<Task> selectCompletedTasks();
    
    // タスクの詳細情報取得
    Task selectTask(int taskId);
    
    // タスクの一件登録
    void insertTask(Task task);
    
    // 完了フラグを未完了から完了に更新
    void updateCompletedFlagToTrue(int taskId);
    
    // 完了フラグを完了から未完了に更新
    void updateCompletedFlagToFalse(int taskId);
    
    // タスクの詳細情報更新（完了フラグ変更なし）
    void updateTaskDetailsWithoutCompletedFlag(Task task);
    
    // タスク詳細の更新処理（完了フラグ変更あり）
    void updateTaskDetailsWithCompletedFlag(Task task);
    
    // タスクの一件削除
    void deleteTask(int taskId);
    
}
