package cookiesProject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
public class Servlet1 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		out.println("<h1>Welcome to Servlet 1</h1>");
		out.println("<h1>Hello "+name+"</h1><br>");
		Cookie c = new Cookie("user_name",name);
		res.addCookie(c);
		out.println("<form action='serv2'> <button type='submit'>Go to Servlet 2</button></form>");
	}
}
