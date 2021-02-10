package br.com.bmo.taskmanager.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.TaskDao;
import br.com.bmo.taskmanager.model.TaskModel;

public class UpdateTask implements ControllerAction {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		String taskName = request.getParameter("taskName");
		Date dueDate = null; 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dueDate = sdf.parse(request.getParameter("dueDate"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		TaskDao taskDao = new TaskDao();
		TaskModel taskFound = taskDao.selectTaskByUUID(uuid);
		taskFound.setDescription(taskName);
		taskFound.setDueDate(dueDate);
		taskDao.updateTask(taskFound);
		
		return "redirect:task?action=ListTask";
	}
}
