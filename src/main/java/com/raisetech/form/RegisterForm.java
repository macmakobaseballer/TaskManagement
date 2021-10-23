package com.raisetech.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;

@Data
public class RegisterForm {

    @Length(min=1,max=100)
    @NotNull
    private String taskContent;

    @DateTimeFormat(pattern="yyyy/MM/dd")
    private LocalDate taskDeadline;

    @Length(max=200)
    private String taskNote;

}
