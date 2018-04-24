package com.ericsson.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.demo.dto.TaskDTO;
import com.ericsson.demo.mapper.TaskMapper;
import com.ericsson.demo.model.Task;
import com.ericsson.demo.repository.TaskRepository;
import com.ericsson.demo.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskMapper taskMapper;

	@Override
	public List<TaskDTO> getTasksByUserId(Long userId) {
		return taskMapper.toDto(taskRepository.findByUserId(userId));
	}

	@Override
	public TaskDTO createTask(TaskDTO taskDto) {
		Task task = taskMapper.toEntity(taskDto);
		return taskMapper.toDto(taskRepository.save(task));
	}
	
	@Override
	public TaskDTO updateTask(TaskDTO taskDto) {
		Task task = taskMapper.toEntity(taskDto);
		return taskMapper.toDto(taskRepository.save(task));
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.delete(id);
	}

	@Override
	public TaskDTO findById(Long id) {
		return taskMapper.toDto(taskRepository.findOne(id));
	}

}
