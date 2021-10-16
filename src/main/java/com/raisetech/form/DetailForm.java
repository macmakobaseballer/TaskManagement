package com.raisetech.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DetailForm {

	private int taskId;
	private boolean completedFlag;
	private String taskContent;
	private String taskNote;
	private LocalDate task_deadline;
}