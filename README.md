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

# Deployment Descriptor:

It is file that contains configuration of java web application it is also known as "web.xml".
The location of this file must be inside the WEB_INF Folder.


------------------------------------------------

------------------------------------------------


# Session Tracking in Servlet:

1. Session Tracking is technique to manage the session state(data) of the user.
2. It is also known as state management.

We know that http is stateless Protocol.

What is Stateless Protocol?

Stateless Protocol is protocol in which whenever server receives a request from client it will treat as new request coming to the server even though it is coming from same source or for same reason. Server doesn't remember data for any request.

Ex.

If client send request to server to see client details. For the first time server ask him for login details and then shows the user details. after that if user doesn't logout server should not ask for login again and directly show the user details but in statlesss as it treat every request as new request the number of times user want to see his user details number of time he neeed to login and follow the same process which he follows for the first request.

There are 4 session tracking techniques in java:

1. Cookies
2. Hidden form field
3. URL Rewritting
4. HttpSession

------------------------------------------------


# Why to Track Session?

If Client send name to first servlet then first servlet is able to print that name but if client go to next servlet using sumbit button of the first servlet and try to print same name on the second servlet. Second servlet is not able to print the name which was printed by the first servlet. This Problem occurs as server is not able to remember the data of the user.


------------------------------------------------

# Cookies in Servlet:


Cookies are the textual information stored in key value pair format to the clients browser during multiple request.

When Client send request to the server for first time server send response along with the cookies. This cookies are stored in the client browser. when client send request second time then the server parse the cookies and check if these is the same user and give response otherwise if it finds another cookies then server ask for the login to the user again and treat as stateless server.


How to use cookies in java:

There is Cookie Class Present in the javax.servlet.http package. 

To make Cookie object pass name and value in the cookie class object.

Ex:

username = "ABC"

Cookie c = new Cookie("name",username)
resp.addCookie(c) //To add Cookies in response

If you want to take the get Cookies for the request there may be multiple cookies hence getCookies() method of HttpServletRequest Class Return the array of cookies.

Cookies arr[] = req.getCookies();

Disadvantages of Cookies:

1. You are not able to pass space in the name you are passing in the cookies.

Ex:

"Prem" is accepted in cookies.
"Prem Bansod" is not accepted in cookies.

------------------------------------------------
# Connect Mysql to the Servlet.

Add mysql-connector jar file in the webapps/WEB_INF/lib/ folder.

To stop sending To next servlet use the ajax i.e. asynchronous javascript.

$("#myform").on('submit', function(event) {
	event.preventDefault(); //This function is responsible for stop sending To next servlet.
}

1. if The Form data contains only text fields then we can serialise the object in the javascript and use them.
2. if the form contains the "Image" we are not able to "serialize" the form object. we need to use "FormData" class and store it in the "let" type object.

Ex.

let f = new FormData(this)

------------------------------------------------

"Part" class is used to store the image type content or file type content.
Ex:
Part obj = req.getPart("image");


To store multimedia file provide the annotation "@MultiPartConfig" above the class Name.

File.seprator is used to give seprator in filepath.

Ex. if the project is running on linux it will take inbuild value as "/" if it is working on the windows it will take value as "\\".


------------------------------------------------

# URL Rewriting

URL rewriting is process of appending or modifying any url structure while loading a page.

Ex:

any localhost website name/ then this shows the default page index.html

but when we provide localhost webiste name?name=Prem at runtime then this is known as URL Rewriting as we take the input from url and print it.

if we print name then it is prem

if we change name=prem_Bansod and hit the website it will print that name provided in the url.

------------------------------------------------
