package br.com.bmo.taskmanager.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.FakeDB;
import br.com.bmo.taskmanager.model.TaskModel;

public class CreateTask implements ControllerAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String taskDescription = request.getParameter("taskDescription");
		String taskLongDescription = request.getParameter("taskLongDescription");
		Date dueDate = null; 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dueDate = sdf.parse(request.getParameter("dueDate"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		FakeDB taskDao = new FakeDB();
		TaskModel taskModel = new TaskModel(taskDescription, dueDate);
		taskModel.setLongDescription(taskLongDescription);
		taskDao.createTask(taskModel);			
		
		return "redirect:controller?action=ListTask";
	}
}
