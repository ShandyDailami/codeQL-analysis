import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_47377_SessionManager_A07 implements Servlet {
    private HttpServletRequest request; // hold reference to incoming HTTP Request
    
	public void init(ServletConfig config) throws ServletException{  }  		// no setup necessary, just for initializing the servlets during startup only      		        	 	       	   	     			       									     	}                 public void service (HttpServletRequest req , HttpServletResponse resp )throws IOException {            request =req;                           String username=request.getParameter("username");
    if(!"testuser".equals(username)){ //if the user is not testUser  then we throw an exception to simulate authentication failure  				throw new ServletException ("Authentication Failed for this User " + username);             } else {                                                                                          System.out.println ( "\n\t*** Authentication Successful - Log in Secured Page *** \n" );     }}
}        public String getServletInfo() 										{   return null;   		} private ServletConfig config ; //to initialize this servlets during startup only        		                                                                                     }                 '