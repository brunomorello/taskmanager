package br.com.bmo.taskmanager.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bmo.taskmanager.model.User;

public class TestUserToTaskJoin {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, 4L);
		
		System.out.println(user.getFirstName() + " has " + user.getTasks().size() + " tasks");
	}
}
