package br.com.bmo.taskmanager.model;

public class TaskModel {

	private String uuid;
	private String description;
	
	public TaskModel(String description) {
		this.description = description;
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
	
}
