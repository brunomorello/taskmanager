package br.com.bmo.taskmanager.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bmo.taskmanager.model.User;

public class TestInsertUser {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		User user = new User("Bruno", "bmo2", "123");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		emf.close();
	}
}
