package br.com.bmo.taskmanager.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.TaskModel;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/task")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		if (!uuid.isEmpty()) {
			System.out.println("updating task");
			TaskModel taskFound = taskDao.selectTaskByUUID(uuid);
			taskFound.setDescription(taskName);
			taskFound.setDueDate(dueDate);
			taskDao.updateTask(taskFound);
		} else {
			System.out.println("creating task");
			TaskModel taskModel = new TaskModel(taskName, dueDate);
			taskDao.createTask(taskModel);			
		}
			
		response.sendRedirect("tasksList");
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/newTaskCreated.jsp");
//		request.setAttribute("task", taskModel.getDescription());
//		requestDispatcher.forward(request, response);

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uuid = request.getParameter("uuid");
		
		TaskDao taskDao = new TaskDao();
		TaskModel task = taskDao.selectTaskByUUID(uuid);
		
		request.setAttribute("task", task);
		RequestDispatcher reqDisp = request.getRequestDispatcher("formTask.jsp");
		reqDisp.forward(request, response);		
		
	}

}
