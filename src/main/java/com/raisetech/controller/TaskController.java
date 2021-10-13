package com.raisetech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raisetech.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("tasks", taskService.getTasks());
		model.addAttribute("finTasks", taskService.getFinTasks());
		
		return "task/index";
	}
	
}
