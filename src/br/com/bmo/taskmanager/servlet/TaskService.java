package br.com.bmo.taskmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.bmo.taskmanager.dao.FakeDB;
import br.com.bmo.taskmanager.model.TaskModel;

/**
 * Servlet implementation class TaskService
 */
@WebServlet("/TaskService")
public class TaskService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FakeDB db = new FakeDB();
		List<TaskModel> tasks = db.getTasks();
		
		Gson gson = new Gson();
		String tasksListJSON = gson.toJson(tasks);
		
		response.setContentType("application/json");
		response.getWriter().print(tasksListJSON);
		
	}

}
