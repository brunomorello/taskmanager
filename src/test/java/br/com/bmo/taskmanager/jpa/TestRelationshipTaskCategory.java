package br.com.bmo.taskmanager.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.bmo.taskmanager.model.Category;
import br.com.bmo.taskmanager.model.Task;
import br.com.bmo.taskmanager.model.User;

public class TestRelationshipTaskCategory {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		Category category = new Category();
		category.setId(1L);
		
		User owner = new User();
		owner.setId(4L);
		
		String jpql = "select t from Task t where t.owner = :pOwner";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pOwner", owner);
		List<Task> resultList = query.getResultList();
		
		resultList.stream().forEach(task -> System.out.println(task.getDescription()));
	}
}
