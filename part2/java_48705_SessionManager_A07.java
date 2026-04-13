import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;    // Imported for IOException below     
public class java_48705_SessionManager_A07 extends HttpServlet {    
       public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
               String username = request.getParameter("username");  
               if ("test".equals(username)) {    // Correct credentials - no session will be created in this case     
                       Cookie cookie1= new Cookie("user", "loggedInAs"+uuid());     /* Creating a Session ID for the user */ 
                     request.getSession().setAttribute("sessionID",cookie1);    // Storing User's session id on Servlet-side  
                      response.sendRedirect(request.getContextPath() + "/welcome");// Redirection to another page, access is allowed after logging in      }  else {        /* Incorrect credentials */     Cookie cookie2 = new Cookie("user", "IncorrectCredentialsAs"+uuid());
                     request.getSession().setAttribute("sessionID_failure",cookie1);    // Storing the session id of login failure on Servlet-side     
                      response.sendRedirect(request.getContextPath() + "/loginFailed");  /* Redirection to a new page */ }     }}  
        private String uuid(){ return java.util.UUID.randomUUID().toString();}    // Function for generating unique IDs (for session management)      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doPost(request,response)}     /* All HTTP methods need a "public" declaration */