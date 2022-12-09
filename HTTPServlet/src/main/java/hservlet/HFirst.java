package hservlet;

import java.io.*;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class HFirst extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		System.out.println("Inside the Do Get Method");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>This is do get Method in Servlet.</h1>");
		out.println(new Date().toString());
	}
}
