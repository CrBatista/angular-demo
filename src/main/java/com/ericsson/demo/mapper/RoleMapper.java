package com.ericsson.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ericsson.demo.dto.RoleDTO;
import com.ericsson.demo.model.Role;
import com.ericsson.demo.utils.EricssonUtils;

@Component
public class RoleMapper {

	public RoleDTO toDto(Role role) {
		if (EricssonUtils.isNullOrBlank(role)) {
			return null;
		}
		
		RoleDTO roleDto = new RoleDTO();
		
		roleDto.setId(role.getId());
		roleDto.setName(role.getName());
		
		return roleDto;
	}
	
	public List<RoleDTO> toDto(List<Role> roles) {
		if (EricssonUtils.isNullOrEmpty(roles)) {
			return null;
		}
		return roles.stream().map(this::toDto).collect(Collectors.toList());
	}
	
}
