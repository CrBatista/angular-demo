package com.ericsson.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ERICSSON_TASK")
public class Task {

	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;

	@Column(name="DONE")
	private Boolean done;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
