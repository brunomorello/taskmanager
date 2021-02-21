package br.com.bmo.taskmanager.jpa;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bmo.taskmanager.model.Task;
import br.com.bmo.taskmanager.model.User;

public class TestTaskUserRelationship {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		User user = new User("Bruno Moreno", "bmo", "123");
		Task task = new Task("Task - Test", LocalDateTime.now());
		task.setOwner(user);
		
		em.getTransaction().begin();
		em.persist(user);
		em.persist(task);
		em.getTransaction().commit();
		emf.close();
	}
}
