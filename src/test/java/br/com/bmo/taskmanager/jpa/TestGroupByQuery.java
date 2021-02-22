package br.com.bmo.taskmanager.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.bmo.taskmanager.model.TaskCountByDayMonth;

public class TestGroupByQuery {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskmanager");
		EntityManager em = emf.createEntityManager();

		// step 1 - using avg ** nonsense example
		String jpql = "select avg(t.id) from Task t";
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		Double qntTasks = query.getSingleResult();
		
		System.out.println("Total Tasks: " + qntTasks);
		
		// step 2 - count tasks by day - specific TypedQuery with custom object
//		String jpql2 = "select c.name, day(t.createdAt), month(t.createdAt) from Task t left join fetch t.category c group by c.name, day(t.createdAt), month(t.createdAt)";
		String jpql2 = "select new br.com.bmo.taskmanager.model.TaskCountByDayMonth(day(t.createdAt), month(t.createdAt), count(*) as total) from Task t group by day(t.createdAt), month(t.createdAt)";
		
		TypedQuery<TaskCountByDayMonth> query2 = em.createQuery(jpql2, TaskCountByDayMonth.class);
		List<TaskCountByDayMonth> tasksCountByDay = query2.getResultList();
		
		for (TaskCountByDayMonth result : tasksCountByDay) {
			System.out.println("Tasks created on day " + result.getDay() + " month: " + result.getMonth() + " month: " + result.getTotal());
		}
	}
}
