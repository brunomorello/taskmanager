package br.com.bmo.taskmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.TaskModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		
		TaskModel taskModel = new TaskModel(request.getParameter("taskName"));
		
		TaskDao taskDao = new TaskDao();
		taskDao.createTask(taskModel);
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("taskName");
		out.println("<html><body>Task " + id + " Created</body></html>");
	}

}
