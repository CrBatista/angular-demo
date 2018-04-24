package com.ericsson.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name="ERICSSON_USER")
public class User {

	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Task> tasks;

	@OneToMany
	@JoinTable(name = "ERICSSON_USER_ROLE",
		joinColumns = {
				@JoinColumn(table = "ERICSSON_USER", name = "USER_ID", referencedColumnName = "id") },
		inverseJoinColumns = {
				@JoinColumn(table = "ERICSSON_ROLE", name = "ROLE_ID", referencedColumnName = "id") })
	private List<Role> roles;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
