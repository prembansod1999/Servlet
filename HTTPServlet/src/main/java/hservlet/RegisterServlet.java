package hservlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>Welcome To the Register Servlet.</h1>");
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_password");
		String email = req.getParameter("user_email");
		String gender = req.getParameter("user_gender");
		String course = req.getParameter("user_course");
		String cond = req.getParameter("condition");
		
		if(cond!=null&&cond.equals("checked")) {
			out.println("<h2>"+"Name: "+name+"</h2>");
			out.println("<h2>"+"Password: "+pass+"</h2>");
			out.println("<h2>"+"Email: "+email+"</h2>");
			out.println("<h2>"+"Gender: "+gender+"</h2>");
			out.println("<h2>"+"Course: "+course+"</h2>");
			RequestDispatcher reqdisp = req.getRequestDispatcher("hsuccess");
			reqdisp.forward(req, res);
		}
		else {
			out.println("<h2>You have not selected Terms and Conditions</h2>");
			RequestDispatcher reqdisp= req.getRequestDispatcher("index.html");
			reqdisp.include(req, res);
		}
	}
}
