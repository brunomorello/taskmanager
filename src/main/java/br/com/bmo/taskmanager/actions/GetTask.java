package br.com.bmo.taskmanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.FakeDB;
import br.com.bmo.taskmanager.model.Task;

public class GetTask implements ControllerAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		
		FakeDB taskDao = new FakeDB();
		Task task = taskDao.selectTaskByUUID(uuid);
		
		request.setAttribute("task", task);
		return "forward:formTask.jsp";
	}

}
