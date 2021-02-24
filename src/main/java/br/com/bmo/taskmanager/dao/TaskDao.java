package br.com.bmo.taskmanager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.bmo.taskmanager.model.Task;
import br.com.bmo.taskmanager.model.TaskCountByDayMonth;

public class TaskDao {

	private EntityManager em;

	public TaskDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Task> getTaskReportByUserAndCategory() {
		String jpql = "select t from Task t left join fetch t.owner";
		TypedQuery<Task> query = em.createQuery(jpql, Task.class);
		
		return query.getResultList();
	}
	
	// When query is static use jpql
	public List<TaskCountByDayMonth> getTaskCountByDayMonth() {
		// step 2 - count tasks by day - specific TypedQuery with custom object
//		String jpql2 = "select c.name, day(t.createdAt), month(t.createdAt) from Task t left join fetch t.category c group by c.name, day(t.createdAt), month(t.createdAt)";
		String jpql = "select new br.com.bmo.taskmanager.model.TaskCountByDayMonth(day(t.createdAt), month(t.createdAt), count(*) as total) from Task t group by day(t.createdAt), month(t.createdAt)";
		
		TypedQuery<TaskCountByDayMonth> query = em.createQuery(jpql, TaskCountByDayMonth.class);
		return query.getResultList();
	}
	
	// When query is dynamic and complex use Criteria API
	public List<Task> getTaskByDate(Integer day, Integer month, Integer year) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Task> query = builder.createQuery(Task.class);
		
		Root<Task> root = query.from(Task.class);
		List<Predicate> predicates = new ArrayList<>();		
		
		if (day != null) {
			Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("createdAt")), day);
			predicates.add(predicate);
		}
		
		if (month != null) {
			Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("createdAt")), month);
			predicates.add(predicate);
		}
		
		if (year != null) {
			Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("createdAt")), year);
			predicates.add(predicate);
		}
		
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		TypedQuery<Task> typedQuery = em.createQuery(query);
		
		return typedQuery.getResultList();
	}
	
}
