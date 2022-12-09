package First;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Hello implements Servlet{
	ServletConfig conf;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Inside the Destroy method");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.conf;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "This is the first Servlet";
	}

	@Override
	public void init(ServletConfig conf) throws ServletException {
		// TODO Auto-generated method stub
		this.conf = conf;
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>Welcome to the First Servlet</h1>");
	}

}
