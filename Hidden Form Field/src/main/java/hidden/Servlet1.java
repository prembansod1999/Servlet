package hidden;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String name = req.getParameter("uname");
		out.println("<h1>Welcome " + name + " to Servlet 1</h1>");
		out.println("<form action='servlet2' method='post'>" + "<input type='hidden' name='uname' value='"+name+"'/><button type='submit'>Go to Servlet 2</button>"+"</form>");
	}
}
