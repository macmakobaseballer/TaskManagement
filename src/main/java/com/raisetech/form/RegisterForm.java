package com.raisetech.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegisterForm {

    @Size(max = 100)
    @NotBlank
    private String taskContent;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate taskDeadline;

    @Size(max = 200)
    private String taskNote;

}
