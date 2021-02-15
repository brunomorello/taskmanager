package br.com.bmo.taskmanager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MonitoringFilter
 */
public class MonitoringFilter implements Filter {
	
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
		
		long initExec = System.currentTimeMillis();
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String action = httpRequest.getParameter("action");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		long endExec = System.currentTimeMillis();
		
		System.out.println("Action [" + action + "] execution time: " + (endExec - initExec));
	}
}
