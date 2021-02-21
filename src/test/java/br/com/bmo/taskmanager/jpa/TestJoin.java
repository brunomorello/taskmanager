package br.com.bmo.taskmanager.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.bmo.taskmanager.model.Category;
import br.com.bmo.taskmanager.model.Task;

public class TestJoin {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		Category category = new Category();
		category.setId(1L);
		
		String jpql = "select t from Task t join t.category c where c = :pCategory";
		TypedQuery<Task> query = em.createQuery(jpql, Task.class);
		query.setParameter("pCategory", category);
		List<Task> resultList = query.getResultList();
		
		resultList.stream().forEach(task -> System.out.println(task.getDescription() + " " + task.getCategory()));
		
		
	}
}
