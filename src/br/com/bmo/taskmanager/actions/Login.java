package br.com.bmo.taskmanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.dao.FakeDB;
import br.com.bmo.taskmanager.model.User;

public class Login implements ControllerAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		
		FakeDB queryUser = new FakeDB();
		User user = queryUser.selectUserByLogin(login);
		
		System.out.println(user.canLogin(login, pwd));
		System.out.println("user trying to login: " + login);
		
		return "redirect:controller?action=ListTask";
	}

}
