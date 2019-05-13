package com.dani.coupons.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		//checking the existence of session. If session exists, then it returns the reference of that session object.
		//if not, this methods will return null.
		HttpSession session=req.getSession(false);
		String pageRequested=req.getRequestURL().toString();
		if (session!=null || pageRequested.endsWith("/login")) {
			chain.doFilter(request, response);
			return;
	}	
		//if the session is null, we set the status of the request to unauthorized
		res.setStatus(401);
	}

	public void init(FilterConfig config) throws ServletException {}
	public void destroy() {}
}
