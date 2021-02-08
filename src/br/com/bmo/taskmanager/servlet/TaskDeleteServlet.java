package br.com.bmo.taskmanager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.TaskDao;

/**
 * Servlet implementation class TaskDeleteServlet
 */
@WebServlet(name = "deleteTask", urlPatterns = { "/deleteTask" })
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskUUID = request.getParameter("uuid");
		System.out.println("taskUUID " + taskUUID);
		
		TaskDao taskDao = new TaskDao();
		taskDao.deleteTask(taskUUID);
		
		response.sendRedirect("tasksList");
	}

}
