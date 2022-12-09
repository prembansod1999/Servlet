package cookiesProject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
public class Servlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Cookie arr[] = req.getCookies();
		out.println("<h1>Welcome to Servlet 2</h1>");
		if(arr == null) {
			out.println("<h1>You are New User Please Go to Servlet 1</h1>");
			return;
		}
		
		for(Cookie c:arr) {
			if(c.getName().equals("user_name")) {
				out.println("<h1> Hello "+c.getValue()+" Welcome Back</h1>");
				return;
			}
		}
		out.println("<h1>You are New User Please Go to Servlet 1</h1>");
	}
}
