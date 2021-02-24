package br.com.bmo.taskmanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bmo.taskmanager.model.Task;

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
	
}
