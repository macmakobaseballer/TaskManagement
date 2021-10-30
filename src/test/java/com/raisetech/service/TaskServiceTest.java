package com.raisetech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.raisetech.entity.Task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    private static TaskService sut;

    @BeforeAll
    public static void setUp() throws Exception {
        sut = new TaskService();
    }

    @Test
    public void タスクIDを渡すとそれに紐づくタスクを表示する() throws Exception {
        Task result = sut.showTask(1);
        assertEquals(1, result.getTaskId());
    }

}
