package br.com.bmo.taskmanager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bmo.taskmanager.actions.ControllerAction;

/**
 * Servlet Filter implementation class ControllerFilter
 */
public class ControllerFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String action = request.getParameter("action");
		
		try {
			Class obj = Class.forName("br.com.bmo.taskmanager.actions." + action);
			ControllerAction controller = (ControllerAction) obj.newInstance();

			String dispatcherConfig = controller.execute(httpRequest, httpResponse);
			
			String dispatcherType = dispatcherConfig.split(":")[0];
			String dispatcherTo = dispatcherConfig.split(":")[1]; 
			
			if (dispatcherType.equals("forward")) {
				RequestDispatcher requestDispatcher = httpRequest.getRequestDispatcher("WEB-INF/view/" + dispatcherTo);
				requestDispatcher.forward(httpRequest, httpResponse);
			} else {
				httpResponse.sendRedirect(dispatcherTo);
			}
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		} 
	}

}
