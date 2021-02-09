package br.com.bmo.taskmanager.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.TaskModel;

public class TaskUpdate {

	public void getTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		
		TaskDao taskDao = new TaskDao();
		TaskModel task = taskDao.selectTaskByUUID(uuid);
		
		request.setAttribute("task", task);
		RequestDispatcher reqDisp = request.getRequestDispatcher("formTask.jsp");
		reqDisp.forward(request, response);		
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		String taskName = request.getParameter("taskName");
		Date dueDate = null; 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dueDate = sdf.parse(request.getParameter("dueDate"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		TaskDao taskDao = new TaskDao();
		TaskModel taskFound = taskDao.selectTaskByUUID(uuid);
		taskFound.setDescription(taskName);
		taskFound.setDueDate(dueDate);
		taskDao.updateTask(taskFound);
			
		response.sendRedirect("task?action=list");
	}
}
