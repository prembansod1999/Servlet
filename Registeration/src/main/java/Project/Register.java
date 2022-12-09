package Project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class Register extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		String pass = req.getParameter("user_pass");
		Part image = req.getPart("image");
		String filename = image.getSubmittedFileName();
		try {
			Thread.sleep(3000);
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","alef","alef@123");
			String q = "insert into user(name,password,email,image) values(?,?,?,?)";
			
			PreparedStatement pr = con.prepareStatement(q);
			pr.setString(1, name);
			pr.setString(2, pass);
			pr.setString(3, email);
			pr.setString(4, filename);
			pr.executeUpdate();
			
			InputStream is = image.getInputStream();
			byte[] arr = new byte[is.available()];
			is.read(arr);
			String path = req.getRealPath("/")+"img"+File.separator+filename;
			
			out.println(path);
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(arr);
			fos.close();
			
			out.println("Done");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			out.println("Inside The Exception");
		}
	}
}
