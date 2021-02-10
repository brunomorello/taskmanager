package br.com.bmo.taskmanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.TaskModel;

public class GetTask implements ControllerAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		
		TaskDao taskDao = new TaskDao();
		TaskModel task = taskDao.selectTaskByUUID(uuid);
		
		request.setAttribute("task", task);
		return "forward:formTask.jsp";
	}

}
