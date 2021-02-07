package br.com.bmo.taskmanager.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bmo.taskmanager.model.TaskModel;

public class TaskDao {

	private static List<TaskModel> tasks = new ArrayList<TaskModel>();
	
	static {
		TaskModel task1 = new TaskModel("task_test_1", new Date());
		TaskModel task2 = new TaskModel("task_test_2", new Date());
		
		TaskDao taskDao = new TaskDao();
		taskDao.createTask(task1);
		taskDao.createTask(task2);
	}
	
	public void createTask(TaskModel task) {
		tasks.add(task);
	}
	
	public List<TaskModel> getTasks() {
		return tasks;
	}
}
