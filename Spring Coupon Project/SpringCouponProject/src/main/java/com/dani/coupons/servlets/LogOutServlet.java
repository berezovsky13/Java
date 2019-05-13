package com.dani.coupons.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		getting the session the user has
		HttpSession session = request.getSession(false);
//		invalidating the session
		session.invalidate();
//		redirecting the user to the main login page
		response.sendRedirect("http://localhost:8080/CouponsProject/");
	}

}
