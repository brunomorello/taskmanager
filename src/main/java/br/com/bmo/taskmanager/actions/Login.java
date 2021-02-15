package br.com.bmo.taskmanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.bmo.taskmanager.auth.Authenticate;
import br.com.bmo.taskmanager.model.User;

public class Login implements ControllerAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		
		System.out.println("user trying to login: " + login);
		
		Authenticate auth = new Authenticate();
		User logedUser = auth.canAccess(login, pwd); 
		
		if (logedUser != null) {
			System.out.println("authenticated!!");
			HttpSession session = request.getSession();
			session.setAttribute("logedUser", logedUser);
			return "redirect:controller?action=ListTask";
		} 
		
		return "redirect:controller?action=LoginForm&error=notAuth";
		
	}

}
