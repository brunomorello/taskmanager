package br.com.bmo.taskmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.actions.TaskCreate;
import br.com.bmo.taskmanager.actions.TaskDelete;
import br.com.bmo.taskmanager.actions.TaskUpdate;
import br.com.bmo.taskmanager.actions.TasksList;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/task")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equals("list")) {
			System.out.println("Displaying Tasks List");
			TasksList controller = new TasksList();
			controller.execute(request, response);
		}
		
		if (action.equals("create")) {
			System.out.println("Creating Task");
			TaskCreate controller = new TaskCreate();
			controller.execute(request, response);
		}
		
		if (action.equals("getTask")) {
			System.out.println("Getting Task");
			TaskUpdate controller = new TaskUpdate();
			controller.getTask(request, response);
		}
		
		if (action.equals("update")) {
			System.out.println("Updating Tasks");
			TaskUpdate controller = new TaskUpdate();
			controller.execute(request, response);
		}
		
		if (action.equals("delete")) {
			System.out.println("Deleting Tasks");
			TaskDelete controller = new TaskDelete();
			controller.execute(request, response);
		}
	}

}
