package br.com.bmo.taskmanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.auth.Authenticate;

public class Login implements ControllerAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		
		System.out.println("user trying to login: " + login);
		
		Authenticate auth = new Authenticate();
		if (auth.canAccess(login, pwd)) {
			System.out.println("authenticated!!");
			return "redirect:controller?action=ListTask";
		} 
		
		return "redirect:controller?action=LoginForm&error=notAuth";
		
	}

}
