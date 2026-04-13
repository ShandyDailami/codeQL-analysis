import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_50300_SessionManager_A01 extends HttpServlet {
    // Store user sessions in a Map for simplicity, this is not recommended as it uses more memory than necessary 
     private static final Map<String , Boolean> loggedUsers = new HashMap<>();  
     
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the session ID and expiration period for each user's requests.  Use cookies to persist information across sessions (this is a very basic form of secure communication).   
		 String sid = UUID.randomUUID().toString();    	  
         request.getSession().setAttribute("sessionID", sid);     	    // Set session ID in the Session object for later reference 
          response.addCookie(new Cookie("JSESSIONID",sid));      	// Add cookie to user's browser   		       			    	  					                  				              	 	}                                                                                                                 }`  `java '@Servlet("/SecureSessionManager") `public class SecureSessionManager extends HttpServlet { private static final Map<String, Boolean> loggedUsers = new HashMap<>();  public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException IOException {}