package com.raisetech.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DetailForm {

	private int taskId;
	private boolean completedFlag;
	private String taskContent;
	private String taskNote;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate taskDeadline;
}