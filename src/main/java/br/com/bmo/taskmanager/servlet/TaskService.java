package br.com.bmo.taskmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

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
		
		String respType = request.getHeader("accept");
		String respStr = null;
		
		if (respType.endsWith("xml")) {
			XStream xstream = new XStream();
			xstream.alias("task", TaskModel.class);
			respStr = xstream.toXML(tasks);
			
			response.setContentType("Application/xml");
		} else if (respType.endsWith("json")){			
			Gson gson = new Gson();
			respStr = gson.toJson(tasks);
			
			response.setContentType("Application/json");
		} else {
			response.setContentType("Application/json");
//			response.setStatus(204);
			respStr = "{\"error\":\"Invalid Accept Content\"}";
		}
		
		response.getWriter().print(respStr);
		
	}

}
