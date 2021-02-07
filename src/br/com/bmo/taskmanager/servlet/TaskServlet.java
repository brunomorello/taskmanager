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
		
		String taskName = request.getParameter("taskName");
		Date dueDate = null; 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dueDate = sdf.parse(request.getParameter("dueDate"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		TaskModel taskModel = new TaskModel(taskName, dueDate);
		
		TaskDao taskDao = new TaskDao();
		taskDao.createTask(taskModel);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/newTaskCreated.jsp");
		request.setAttribute("task", taskModel.getDescription());
		requestDispatcher.forward(request, response);

	}

}
