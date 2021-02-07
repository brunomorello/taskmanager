package br.com.bmo.taskmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.TaskModel;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TasksListServlet
 */
@WebServlet("/tasksList")
public class TasksListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TaskDao taskDao = new TaskDao();
		List<TaskModel> tasksList = taskDao.getTasks();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tasksList.jsp");
		request.setAttribute("tasksList", tasksList);
		requestDispatcher.forward(request, response);
		
	}

}
