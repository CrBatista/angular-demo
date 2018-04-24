package com.ericsson.demo.service;

import java.util.List;

import com.ericsson.demo.dto.RoleDTO;

public interface RoleService {

	public List<RoleDTO> getRolesByUserId(Long userId);
	
}
