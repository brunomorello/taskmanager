package br.com.bmo.taskmanager.jpa;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bmo.taskmanager.model.Category;
import br.com.bmo.taskmanager.model.Task;

public class TestManyToMany {
	public static void main(String[] args) {
		
		Category category1 = new Category("Housekeeping");
		Category category2 = new Category("Clean");
		
		Task task1 = new Task("Do the dishes", LocalDateTime.now());
		task1.setCategory(Arrays.asList(category1, category2));
		
		Task task2 = new Task("Iron Clothes", LocalDateTime.now());
		task1.setCategory(Arrays.asList(category1, category2));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(category1);
		em.persist(category2);
		em.persist(task1);
		em.persist(task2);
		em.getTransaction().commit();
		em.close();
	}
}
