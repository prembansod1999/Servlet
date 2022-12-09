# Servlet

Use jakarta instead of javax in tomcat 10

Ex. 
import jakarta.servlet.*;

To see Response on web page 

1. use res objects method setContentType method to provide the content type
2. take res.getWriter() instance and store it in the PrintWriter out.
3. out.println() method is used to provide the html page content.

EX:

ServletResponse res;
res.setContentType("text/html");
PrintWriter out = res.getWriter();
# out.println("<h1>Welcome To Servlet</h1>");

------------------------------------------------

Servlets:

Servlet is simple java program that runs on server and capable of handling request and generating dynamic response.

------------------------------------------------

javax.servlet.Servlet interface Methods:

1. public abstract void init(javax.servlet.ServletConfig)
2. public ServletConfig getServletConfig()
3. public void service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
4. public abstract java.lang.String getServletInfo()
5. public abstract void destroy()

------------------------------------------------

Life Cycle Methods in Servlet:

1. public abstract void init(javax.servlet.ServletConfig)
3. public void service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
5. public abstract void destroy()

------------------------------------------------

To use the Servlet need to impelemets in class as it is interface and override all the methods of that interface:

To execute Servlet we need to do mapping. Tell server we have created servlet application and run using the URL pattern.

To do mapping use "web.xml" file it is also known as deployment descriptor.

------------------------------------------------
