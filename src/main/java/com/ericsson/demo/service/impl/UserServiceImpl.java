package com.ericsson.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.demo.dto.UserDTO;
import com.ericsson.demo.mapper.UserMapper;
import com.ericsson.demo.model.User;
import com.ericsson.demo.repository.UserRepository;
import com.ericsson.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findById(Long userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public List<UserDTO> findAll() {
		return userMapper.toDto(userRepository.findAll());
	}
	

}
