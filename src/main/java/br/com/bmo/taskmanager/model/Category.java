package br.com.bmo.taskmanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
//	@ManyToMany
//	private List<Task> tasks;

	@Deprecated
	public Category() {
	}
	
	public Category(String name) {
		this.name = name;
	}

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
	
//	public List<Task> getTasks() {
//		return tasks;
//	}
//	
//	public void setTasks(List<Task> tasks) {
//		this.tasks = tasks;
//	}
	
	@Override
	public String toString() {
		return "Category: " + getName();
	}
	
}
