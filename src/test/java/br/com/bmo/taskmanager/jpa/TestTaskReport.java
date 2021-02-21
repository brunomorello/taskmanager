package br.com.bmo.taskmanager.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.bmo.taskmanager.model.Task;

public class TestTaskReport {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select t from Task t left join fetch t.owner";
		TypedQuery<Task> query = em.createQuery(jpql, Task.class);
		
		List<Task> tasks = query.getResultList();
		for (Task task : tasks) {
			System.out.println("Task: " + task.getDescription());
			System.out.println("Due Date: " + task.getDueDate().toString());
			System.out.println("Owner: " + task.getOwner().getFirstName());
			System.out.println("Category: " + task.getCategory());
		}
	}
}
