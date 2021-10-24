package com.raisetech.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raisetech.entity.Task;
import com.raisetech.form.DetailForm;
import com.raisetech.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskDetailController {

	@Autowired
	TaskService taskService;
	
	@Autowired
	ModelMapper modelMapper;
	
	//詳細画面表示
	@GetMapping("/detail/id={id}")
	public String getDetail(@PathVariable int id,@ModelAttribute DetailForm form,Model model) {
		model.addAttribute("detailForm", taskService.getTaskDetails(id));
		
		return "task/detail";
	}
	
	//タスク詳細の更新処理（完了フラグ変更なし）
	@PostMapping(value = "/detail/id={id}",params = "update")
	public String postDetail(@PathVariable int id,Model model,
							@ModelAttribute @Validated DetailForm form,
							BindingResult bindingResult){

		//入力チェックの結果判定
		if (bindingResult.hasErrors()){
            //NGの場合：タスク詳細画面に戻る
            return "task/detail";
        }

		//画面から受け取ったformの内容をtaskに渡す
		Task task = modelMapper.map(form,Task.class);
		task.setTaskId(id);
	    //更新処理
		taskService.updateTaskDetails(task);
		
		return "redirect:/task/";
	}
	
	//タスク詳細の更新処理（完了フラグ変更あり）
	@PostMapping(value = "/detail/id={id}",params = "complete")
	public String postTaskCompleted(@PathVariable int id,Model model,
									@ModelAttribute @Validated DetailForm form,
									BindingResult bindingResult){

        //入力チェックの結果判定
        if (bindingResult.hasErrors()){
            //NGの場合：タスク詳細画面に戻る
            return "task/detail";
        }

		//画面から受け取ったformの内容をtaskに渡す
		Task task = modelMapper.map(form,Task.class);
		task.setTaskId(id);
	    //更新処理
		taskService.updateTaskAllDetails(task);
		
		return "redirect:/task/";
	}
	
	//完了フラグをfalseに戻す処理
	@PostMapping(value = "/detail/id={id}",params = "incomplete")
	public String postTaskIncompleted(@PathVariable int id,Model model,
									@ModelAttribute  DetailForm form,
									BindingResult bindingResult){

		//入力チェックの結果判定
		if (bindingResult.hasErrors()){
		//NGの場合：タスク詳細画面に戻る
		return "task/detail";
		}

		//画面から受け取ったformの内容をtaskに渡す
		Task task = modelMapper.map(form,Task.class);
		task.setTaskId(id);
	    //更新処理
		taskService.updateCompletedFlagToFalse(id);
		
		return "redirect:/task/";
	}
	
	//タスクの削除
	@PostMapping(value = "/detail/id={id}",params = "delete")
	public String postDelete(@PathVariable int id,Model model,@ModelAttribute DetailForm form) {
		 taskService.deleteTask(id);
		
		return "redirect:/task/";
	}
}
