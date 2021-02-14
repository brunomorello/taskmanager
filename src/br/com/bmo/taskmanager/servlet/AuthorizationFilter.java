package br.com.bmo.taskmanager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorizationFilter
 */
public class AuthorizationFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String action = httpRequest.getParameter("action");
		
		HttpSession session = httpRequest.getSession();
		boolean userIsNotLogedIn = (session.getAttribute("logedUser") == null);
		
		boolean publicAccess = !(action.equals("Login") || action.equals("LoginForm"));
		
		if (publicAccess && userIsNotLogedIn) {
			httpResponse.sendRedirect("controller?action=LoginForm");
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
