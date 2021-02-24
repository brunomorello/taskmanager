package br.com.bmo.taskmanager.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.Task;

public class TestTaskReport {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		TaskDao taskDao = new TaskDao(em);
		
		List<Task> tasks = taskDao.getTaskReportByUserAndCategory();	
		for (Task task : tasks) {
			System.out.println("Task: " + task.getDescription());
			System.out.println("Due Date: " + task.getDueDate().toString());
			System.out.println("Owner: " + task.getOwner().getFirstName());
//			System.out.println("Category: " + task.getCategory());
		}
	}
}
