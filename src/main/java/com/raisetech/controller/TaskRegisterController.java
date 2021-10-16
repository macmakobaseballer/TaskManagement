package com.raisetech.controller;

import com.raisetech.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskRegisterController {

    @Autowired
    TaskService taskService;

    @GetMapping("/register")
    public String register(){

        return "task/register";
    }

}
