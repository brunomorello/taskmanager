package br.com.bmo.taskmanager.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.TaskModel;

public class TaskCreate {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String taskName = request.getParameter("taskName");
		Date dueDate = null; 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dueDate = sdf.parse(request.getParameter("dueDate"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		TaskDao taskDao = new TaskDao();
		TaskModel taskModel = new TaskModel(taskName, dueDate);
		taskDao.createTask(taskModel);			
			
		response.sendRedirect("task?action=list");
	}
}
