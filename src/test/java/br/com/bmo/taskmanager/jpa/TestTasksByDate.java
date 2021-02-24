package br.com.bmo.taskmanager.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.Task;

public class TestTasksByDate {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		TaskDao taskDao = new TaskDao(em);
		List<Task> tasksList = taskDao.getTaskByDate(null, null, 2020);
		
		tasksList.stream().forEach(task -> {
			System.out.println("Task: " + task.getDescription());
			System.out.println("CreatdAt " + task.getCreatedAt().toString());
			System.out.println("-------------------------------------");
		});
	}
}
