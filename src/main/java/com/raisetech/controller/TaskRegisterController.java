package com.raisetech.controller;

import com.raisetech.entity.Task;
import com.raisetech.form.RegisterForm;
import com.raisetech.service.TaskService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskRegisterController {

    @Autowired
    TaskService taskService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/register")
    public String getRegister(@ModelAttribute RegisterForm form ){

        return "task/register";
    }

    @PostMapping("/register")
    public String postRegister(Model model,@ModelAttribute RegisterForm form){
        //画面から受け取ったformの内容をtaskに渡す
        Task task = modelMapper.map(form,Task.class);
        //登録処理
        taskService.registerTask(task);

        return "redirect:/task/";

    }


}
