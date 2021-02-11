package br.com.bmo.taskmanager.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.FakeDB;

public class DeleteTask implements ControllerAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskUUID = request.getParameter("uuid");
		System.out.println("taskUUID " + taskUUID);
		
		FakeDB taskDao = new FakeDB();
		taskDao.deleteTask(taskUUID);
		
		return "redirect:controller?action=ListTask";
	}
}
