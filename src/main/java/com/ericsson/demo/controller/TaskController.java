package com.ericsson.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ericsson.demo.dto.TaskDTO;
import com.ericsson.demo.service.TaskService;
import com.ericsson.demo.utils.EricssonUtils;

@Controller
@RequestMapping(value="/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping(value="/user")
	@ResponseBody
	public List<TaskDTO> getTasksByUserId(@RequestParam("id") Long userId) {
		return taskService.getTasksByUserId(userId);
	}
	
	@PostMapping(value="/")
	@ResponseBody
	public TaskDTO createTask(TaskDTO taskDto) {
		return taskService.createTask(taskDto);
	}
	
	@PutMapping(value="/")
	@ResponseBody
	public TaskDTO updateTask(@RequestBody TaskDTO taskDto) {
		return taskService.updateTask(taskDto);
	}
	
	@DeleteMapping(value="{id}")
	@ResponseBody
	public Boolean deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return EricssonUtils.isNullOrBlank(taskService.findById(id));
	}
}
