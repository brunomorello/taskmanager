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
		
		request.setAttribute("tasksList", tasksList);

		return "forward:tasksList.jsp";
	}
}
