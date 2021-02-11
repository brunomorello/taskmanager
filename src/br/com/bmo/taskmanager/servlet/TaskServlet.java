package br.com.bmo.taskmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.actions.ControllerAction;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/controller")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		try {
			Class obj = Class.forName("br.com.bmo.taskmanager.actions." + action);
			ControllerAction controller = (ControllerAction) obj.newInstance();

			String dispatcherConfig = controller.execute(request, response);
			
			String dispatcherType = dispatcherConfig.split(":")[0];
			String dispatcherTo = dispatcherConfig.split(":")[1]; 
			
			if (dispatcherType.equals("forward")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + dispatcherTo);
				requestDispatcher.forward(request, response);
			} else {
				response.sendRedirect(dispatcherTo);
			}
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		} 
		
	}

}
