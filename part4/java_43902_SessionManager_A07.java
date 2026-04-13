import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_43902_SessionManager_A07 extends HttpServlet {   // define servlets by extending Httpservletclass and overriding doGet method (Http Servlet in Java)   
    
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{             
      String username = request.getParameter("username");   // get parameter from form input named 'user' of type string        
	  String password= new String(request.getParameter("password").getBytes());  // convert the encrypted text to a normal one before using it in any operations (security-sensitive operation)      
	    	   		   				// Assuming we have another servlet or method for checking authentication here, which is not mentioned hence commented out  				        					     	 	     	       	}           else {  // if user name and password do no match then return to login form with error message                     response.sendRedirect("loginErrorPage");    }
     public void service(ServletRequest req , ServletResponse res, HttpSession session) throws IOException{      	//session will be created here when the request is serviced by this method        // This also includes checking for authentication as per your instructions         		}        		 	        });