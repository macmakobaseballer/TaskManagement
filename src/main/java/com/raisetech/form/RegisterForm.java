package com.raisetech.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegisterForm {

    private String taskContent ;

    @DateTimeFormat(pattern="yyyy/MM/dd")
    private LocalDate taskDeadline ;

    private String taskNote ;

}
