package com.ericsson.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ericsson.demo.dto.UserDTO;
import com.ericsson.demo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@GetMapping(value="/all")
	public List<UserDTO> getAll() {
		return userService.findAll();
	}

}
