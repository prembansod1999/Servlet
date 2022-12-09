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
out.println("Welcome To Servlet");

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
Servlet declaration has two tags which needs to be added in the <servlet></servlet> tags.
1. <servlet-name> Any name Ex.(prem) </servlet-name> . this is used to provide name to the servlet class which class is declared below in servlet-class tags.  
2. <servlet-class></servlet-class> . This is used to provide name of the full class using package name. Ex. if com is package and First is name of class then provide it as <servlet-class>com.First</servlet-class>

Ex:
<servlet>
	<servlet-name>prem</servlet-name>
	<servlet-class>com.First</servlet-class>
</servlet>

------------------------------------------------

Servlet Mapping tag is <servlet-mapping></servlet-mapping>

It has also two attribute
1. <servlet-name>Name of Servlet same as declared above</servlet-name>
2. <url-pattern>/web</url-pattern> url is declared in this tag

Ex.

<servlet-mapping>
	<servlet-name>prem</servlet-name>
	<url-pattern>/web</url-pattern>
</servlet-mapping>

------------------------------------------------

# Generic Servlet:

GenericServlet class is used to implements the Servlet interface and implements 4 methods body but take 1 method abstract is service() method.

------------------------------------------------


# Http Servlet:

1. HttpServlet is class derieved from the GenericServlet Class. 
2. It supports get, post and put method.
3. There are no abstract methods in this class.
4. we can override the methods on the basis of the requirements. There are three methods doGet(), doPost(), and doPut()
5. public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
6. public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
7. To get the Parameters value from any web field use the req object and getParatmeter() method and provide name of that parameter in that function.
EX.
<input type="text" name="user_name/>
String name = req.getParameter("user_name")

------------------------------------------------

Welcome File and Welcome File list

In this there are two tags.

<welcome-file-list>
	<welcome-file>Provide the Name of File which you want to display for default page</welcome-file>
</welcome-file-list>

The Default File names are index.html, default.html etc.
if there are multiple welcome-files are present in the welcome-file-list then it will check for the file if it is present or not and if any file is found then it will show that file.

<welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.jsp</welcome-file>
</welcome-file-list>

if index.html is present in the project then it will print index.html.
if index.html is not present then search for index.jsp if it is present then display index.jsp.
if index.jsp is not present then it will not showing any file.


------------------------------------------------


RequestDispatcher

It is important interface and use to dispatching the request to another resource it may be html, servlet or jsp etc.

It is known as RequestDispatcher from servlet1 to servlet2

1. Forward Example:

client---> servlet1 ----> servlet2--
 ^                                  |
 |----------------------------------
       response

2. Include Example:

client---> servlet1 ----> servlet2--
  ^         | ^                      |
  |         | |                      |
  ----------- |----------------------
       response

       
1. It is used to "forward" request from one source to another.
2. It is used to "include" response from other resource.


To implement the include and forward method Example as follow:

RequestDispatcher reqdisp = req.getRequestDispatcher("Provide the name of the servlet which is url-mapper or we can provide the html file names directly");

Ex:
RequestDispatcher reqdisp = req.getRequestDispatcher("index.html");
reqdisp.include(req,res);

The index.html page is showing on this servlet in which it is included.

Ex:
"hsuccess" is url-pattern for the another servlet.
RequestDispatcher reqdisp = req.getRequestDispatcher("hsuccess");
reqdisp.forward(req,res);

------------------------------------------------

Deployment Descriptor:

It is file that contains configuration of java web application it is also known as "web.xml".
The location of this file must be inside the WEB_INF Folder.


------------------------------------------------
