package br.com.bmo.taskmanager.model;

import br.com.bmo.taskmanager.model.state.TaskCategoryState;

public class TaskCategory {

	private String name;
	private TaskCategory parent;
	private String description;
	private TaskCategoryState state = TaskCategoryState.ACTIVE;
	
	public TaskCategory(String name, TaskCategory parent) {
		this.name = name;
		this.parent = parent;
	}
	
	public TaskCategory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public TaskCategory getParent() {
		return parent;
	}
	
	public void setParent(TaskCategory parent) {
		this.parent = parent;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public TaskCategoryState getState() {
		return state;
	}
	
	public void setState(TaskCategoryState state) {
		this.state = state;
	}
	
}
