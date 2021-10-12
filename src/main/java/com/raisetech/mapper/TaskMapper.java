package com.raisetech.mapper;

import com.raisetech.entity.Task;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {

    //計算式1件登録
	void insertTask(Task task);

}
