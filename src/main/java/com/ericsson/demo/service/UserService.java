package com.ericsson.demo.service;

import java.util.List;

import com.ericsson.demo.dto.UserDTO;
import com.ericsson.demo.model.User;

public interface UserService {
	
	public User findById(Long userId);
	public List<UserDTO> findAll();

}
