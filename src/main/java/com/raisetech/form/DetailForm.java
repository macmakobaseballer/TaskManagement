package com.raisetech.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DetailForm {

	private int taskId;

	private boolean completedFlag;

    @Length(max=100)
    @NotBlank
	private String taskContent;

    @Length(max=200)
	private String taskNote;

	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate taskDeadline;

}