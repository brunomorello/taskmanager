package br.com.bmo.taskmanager.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.TaskModel;

public class ListTask implements ControllerAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskDao taskDao = new TaskDao();
		List<TaskModel> tasksList = taskDao.getTasks();
		
		tasksList.sort((task1, task2) -> { return task1.getDescription().compareTo(task2.getDescription()); });
		
		request.setAttribute("tasksList", tasksList);

		return "forward:tasksList.jsp";
	}
}
