package com.luhach.todo.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
    private UUID id;
    private String description;
    private Integer status;

	public Task(){
		this.id = UUID.randomUUID();
		this.status=0;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String value) {
		this.description = value;
	}
	@Override
	public String toString() {
		return "Task [description=" + description + ", id=" + id + ", status=" + status + "]";
	}
    
}
