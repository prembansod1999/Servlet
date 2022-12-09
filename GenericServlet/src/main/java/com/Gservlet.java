package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
public class Gservlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>Welcome to Generic Servlet</h1>");
	}

}
