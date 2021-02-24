package br.com.bmo.taskmanager.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.bmo.taskmanager.model.Task;

public class TestCriteriaQuery {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		
		Root<Task> root = query.from(Task.class);
		
		Expression<Long> total = builder.count(root);
		query.select(total);
		
		TypedQuery<Long> typedQuery = em.createQuery(query);
		
		System.out.println("Total Tasks is " + typedQuery.getSingleResult());
		
	}
}
