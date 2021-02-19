package br.com.bmo.taskmanager.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.FakeDB;
import br.com.bmo.taskmanager.model.Task;

public class UpdateTask implements ControllerAction {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
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
		Task taskFound = taskDao.selectTaskByUUID(uuid);
		taskFound.setDescription(taskDescription);
		taskFound.setLongDescription(taskLongDescription);
		LocalDateTime dueDateObj = LocalDateTime.of(dueDate.getYear(), dueDate.getMonth(), dueDate.getDate(), 0,  0);
		taskFound.setDueDate(dueDateObj);
		taskDao.updateTask(taskFound);
		
		return "redirect:controller?action=ListTask";
	}
}
