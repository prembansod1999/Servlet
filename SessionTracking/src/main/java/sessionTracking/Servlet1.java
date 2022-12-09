package sessionTracking;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class Servlet1 extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		out.println("<h1>Welcome to First Servlet</h1>");
		out.println("<h1>Hello "+name+"</h1>");
		out.println("<form action='serv2' method = 'post'><button type='submit'>Go To Servlet 2</button></form>");
	}
}
