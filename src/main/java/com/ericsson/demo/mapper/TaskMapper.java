package com.ericsson.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.demo.dto.TaskDTO;
import com.ericsson.demo.model.Task;
import com.ericsson.demo.service.UserService;
import com.ericsson.demo.utils.EricssonUtils;

@Component
public class TaskMapper {

	@Autowired
	private UserService userService;
	
	public TaskDTO toDto(Task task) {
		if (EricssonUtils.isNullOrBlank(task)) {
			return null;
		}
		
		TaskDTO taskDto = new TaskDTO();
		
		taskDto.setId(task.getId());
		taskDto.setName(task.getName());
		taskDto.setDone(task.getDone());
		if (!EricssonUtils.isNullOrBlank(task.getUser())) {
			taskDto.setUserId(task.getUser().getId());
		}
		
		return taskDto;
	}
	
	public List<TaskDTO> toDto(List<Task> tasks) {
		if (EricssonUtils.isNullOrEmpty(tasks)) {
			return null;
		}
		return tasks.stream().map(this::toDto).collect(Collectors.toList());
	}
	
	
	public Task toEntity(TaskDTO taskDto) {
		if (EricssonUtils.isNullOrBlank(taskDto)) {
			return null;
		}
		
		Task task = new Task();
		
		task.setId(taskDto.getId());
		task.setName(taskDto.getName());
		task.setDone(taskDto.getDone());
		
		if (!EricssonUtils.isNullOrBlank(taskDto.getUserId())) {
			task.setUser(userService.findById(taskDto.getUserId()));
		}
		
		return task;
	}
}
