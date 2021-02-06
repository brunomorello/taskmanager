package br.com.bmo.taskmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.TaskModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TasksListServlet
 */
@WebServlet("/tasksList")
public class TasksListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TaskDao taskDao = new TaskDao();
		List<TaskModel> tasksList = taskDao.getTasks();
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.println("<ul>");
		for (TaskModel taskModel : tasksList) {
			out.println("<li>" + taskModel.getDescription() + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
	}

}
