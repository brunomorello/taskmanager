package br.com.bmo.taskmanager.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.FakeDB;
import br.com.bmo.taskmanager.model.Task;

public class ListTask implements ControllerAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FakeDB taskDao = new FakeDB();
		List<Task> tasksList = taskDao.getTasks();
		
		tasksList.sort((task1, task2) -> { return task1.getDescription().compareTo(task2.getDescription()); });
		
		request.setAttribute("tasksList", tasksList);

		return "forward:tasksList.jsp";
	}
}
