package br.com.bmo.taskmanager.model;

import java.util.Date;
import java.util.UUID;

import br.com.bmo.taskmanager.model.state.TaskState;

public class TaskModel {

	private String uuid = UUID.randomUUID().toString();
	private String description;
	private String longDescription;
	private Date createdAt = new Date();
	private Date updatedAt;
	private Date dueDate;
	private int order;
	private String priority;
	private User owner;
	private TaskState state = TaskState.BACKLOG;
	
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

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}
	
}
