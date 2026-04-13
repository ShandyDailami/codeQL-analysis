import javax.servlet.*;
import java.io.IOException;
import jakarta.servlet.http.*;
  
public class java_50432_SessionManager_A03 implements Servlet {
    private HttpServletRequest request = null; // Store the incoming HTTP Request for later use by this session manager object if it's needed 
          
          @Override public void init(ServletConfig config) throws ServletException {}        
    
        /* Every time a user logs in, set their username into an existing or new cookie */  
       //TODO: Sanitize and validate input to prevent injection attacks. Use JSTL for this purpose – javax.* is not used here because it's just testing purposes (no need of http requests)   
          public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
              String username = "username_from_" + sanitizeInputFromUser(request.getParameter("uname")); // Sanitation and validation here – JSTL is used for this purpose  	      
          }     
           @Override public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {}    		   	 			       	   	     	       									        	}