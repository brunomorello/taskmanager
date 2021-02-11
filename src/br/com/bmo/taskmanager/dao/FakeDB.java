package br.com.bmo.taskmanager.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.com.bmo.taskmanager.model.TaskModel;
import br.com.bmo.taskmanager.model.User;

public class FakeDB {

	private static List<TaskModel> tasks = new ArrayList<TaskModel>();
	private static List<User> users = new ArrayList<User>();
	
	static {
		TaskModel task1 = new TaskModel("task_test_1", new Date());
		TaskModel task2 = new TaskModel("task_test_2", new Date());
		
		FakeDB taskDao = new FakeDB();
		taskDao.createTask(task1);
		taskDao.createTask(task2);
		
		User user = new User("bruno", "bmo", "123");
		User user2 = new User("fulano", "foo", "bar");
		users.add(user);
		users.add(user2);
	}
	
	public void createTask(TaskModel task) {
		tasks.add(task);
	}
	
	public void updateTask(TaskModel task) {

		for (int i = 0; i < tasks.size(); i++) {
			TaskModel currentTask = tasks.get(i);
			if (currentTask.getUuid().equals(task.getUuid())) {
				tasks.remove(i);
				tasks.add(task);
			}			
		}
	}
	
	public TaskModel selectTaskByUUID(String uuid) {
		
		Iterator<TaskModel> iterator = tasks.iterator();
		
		while(iterator.hasNext()) {
			TaskModel currentTask = iterator.next();
			if (currentTask.getUuid().equals(uuid))
				return currentTask;
		}
		
		return null;
	}
	
	public User selectUserByLogin(String login) {
		
		Iterator<User> iterator = users.iterator();
		
		while (iterator.hasNext()) {
			User currentUser = iterator.next();
			if (currentUser.getLogin().equals(login))
				return currentUser;
		}
		
		return null;
	}
	
	public void deleteTask(String uuid) {
		Iterator<TaskModel> iterator = tasks.iterator();
		
		while (iterator.hasNext()) {
			TaskModel currentTask = iterator.next();
			
			if (currentTask.getUuid().equals(uuid))
				iterator.remove();
		}
	}
	
	public List<TaskModel> getTasks() {
		return tasks;
	}
}
