package br.com.bmo.taskmanager.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.TaskDao;

public class TaskDelete {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskUUID = request.getParameter("uuid");
		System.out.println("taskUUID " + taskUUID);
		
		TaskDao taskDao = new TaskDao();
		taskDao.deleteTask(taskUUID);
		
		response.sendRedirect("task?action=list");
	}

}
