package com.ericsson.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.demo.dto.UserDTO;
import com.ericsson.demo.model.User;
import com.ericsson.demo.utils.EricssonUtils;

@Component
public class UserMapper {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private TaskMapper taskMapper;
	
	
	public UserDTO toDto(User user) {
		if (EricssonUtils.isNullOrBlank(user)) {
			return null;
		}
		
		UserDTO userDto = new UserDTO();
		
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setRoles(roleMapper.toDto(user.getRoles()));
		userDto.setTasks(taskMapper.toDto(user.getTasks()));
		
		return userDto;
	}
	
	public List<UserDTO> toDto(List<User> users) {
		if (EricssonUtils.isNullOrBlank(users)) {
			return null;
		}
		
		return users.stream().map(this::toDto).collect(Collectors.toList());
	}
}
