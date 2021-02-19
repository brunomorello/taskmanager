package br.com.bmo.taskmanager.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.bmo.taskmanager.model.Task;
import br.com.bmo.taskmanager.model.User;

public class FakeDB {

	private static List<Task> tasks = new ArrayList<Task>();
	private static List<User> users = new ArrayList<User>();
	
	static {
		Task task1 = new Task("task_test_1", LocalDateTime.now());
		task1.setLongDescription("Example Task");
		
		Task task2 = new Task("task_test_2", LocalDateTime.now());
		task2.setLongDescription("Example Task");
		
		FakeDB taskDao = new FakeDB();
		taskDao.createTask(task1);
		taskDao.createTask(task2);
		
		User user = new User("Bruno", "bmo", "123");
		User user2 = new User("Fulano", "foo", "bar");
		users.add(user);
		users.add(user2);
	}
	
	public void createTask(Task task) {
		tasks.add(task);
	}
	
	public void updateTask(Task task) {

		for (int i = 0; i < tasks.size(); i++) {
			Task currentTask = tasks.get(i);
			if (currentTask.getUuid().equals(task.getUuid())) {
				tasks.remove(i);
				tasks.add(task);
			}			
		}
	}
	
	public Task selectTaskByUUID(String uuid) {
		
		Iterator<Task> iterator = tasks.iterator();
		
		while(iterator.hasNext()) {
			Task currentTask = iterator.next();
			if (currentTask.getUuid().equals(uuid))
				return currentTask;
		}
		
		return null;
	}
	
	public User selectUserByLogin(String login) {
		
		for (User user : users) {
			if (user.getLogin().equals(login)) return user;
		}
		
		return null;
	}
	
	public void deleteTask(String uuid) {
		Iterator<Task> iterator = tasks.iterator();
		
		while (iterator.hasNext()) {
			Task currentTask = iterator.next();
			
			if (currentTask.getUuid().equals(uuid))
				iterator.remove();
		}
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
}
