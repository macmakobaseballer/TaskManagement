package com.raisetech.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Task {
    
    private int taskId;
    private boolean completedFlag;
    private String taskContent;
    private String taskNote;
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private LocalDate taskDeadline;

}
