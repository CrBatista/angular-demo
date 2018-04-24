package com.ericsson.demo.service;

import java.util.List;

import com.ericsson.demo.dto.TaskDTO;

public interface TaskService {

	public List<TaskDTO> getTasksByUserId(Long userId);

	public TaskDTO createTask(TaskDTO taskDto);

	public TaskDTO updateTask(TaskDTO taskDto);

	public void deleteTask(Long id);

	public TaskDTO findById(Long id);
}
