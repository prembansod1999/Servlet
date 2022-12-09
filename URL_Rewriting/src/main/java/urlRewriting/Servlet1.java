package urlRewriting;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>Welcome to Servlet1</h1>");
		String name = req.getParameter("uname");
		out.println("<h1>"+"Your name is : "+name+"</h1><br><br>");
		out.println("<a href='servlet2?name="+name+"'>Second Servlet</a>");
	}
}
