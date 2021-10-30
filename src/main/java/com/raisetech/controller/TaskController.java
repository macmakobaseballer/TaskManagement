package com.raisetech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raisetech.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("incompleteTasks", taskService.getIncompleteTasks());
        model.addAttribute("completedTasks", taskService.getCompletedTasks());

        return "task/index";
    }

    // 完了フラグ変更(false -> true)
    @PostMapping("/complete/id={id}")
    public String taskComplete(@PathVariable("id") int id) {

        taskService.updateCompletedFlagToTrue(id);

        return "redirect:/task/";
    }

    // 完了フラグ変更(true -> false)
    @PostMapping("/incomplete/id={id}")
    public String taskIncomplete(@PathVariable("id") int id) {

        taskService.updateCompletedFlagToFalse(id);

        return "redirect:/task/";
    }

}
