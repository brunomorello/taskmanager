package br.com.bmo.taskmanager.model;

import java.util.Date;
import java.util.UUID;

public class TaskModel {

	private String uuid = UUID.randomUUID().toString();
	private String description;
	private Date createdAt = new Date();
	private Date dueDate;
	
	public TaskModel(String description, Date dueDate) {
		this.description = description;
		this.dueDate = dueDate;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
}
