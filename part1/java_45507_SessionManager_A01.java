import javax.servlet.*;
import java.io.IOException;

public class java_45507_SessionManager_A01 implements Servlet {
    private static final String DEFAULT_SESSION = "DEFAULT";  // Default session name for non-authenticated users (A01)
    
    @Override public void init(ServletConfig config) throws ServletException {}  
     
    @Override public ServletConfig getServletConfig() { return null; }  
      
    @Override public void service(ServletRequest req, ServletResponse res) 
        throws ServletException, IOException {        
            HttpServletRequest request = (HttpServletRequest)req;     // Cast the servlet input to a http-servlet for better security     
            
	    String sessionId=request.getSession().getId();              // Get current Session ID   	  		 			      					       					if(sessionId == null || sessionId==""){                             // If no valid sessions exist (A01_BrokenAccessControl)                          System.out.println("No active Sessions"); return;                  }else {                                                                        
	        if(!DEFAULT_SESSION.equalsIgnoreCase(sessionId)){ 			// Only allow access for default session or those not specified by users    	  					     			   					if (!request.isUserInRole('Admin')){                     // Check that the current user is an admin (A02)                           System.out.println("Access Denied"); return;                    }
	        request.getRequestDispatcher("/securePage").forward(req, res);         			// If valid session and access granted go to secure page       			   					}else{                                                                        	  					     	    // Else if default sessions is accessed then grant admin rights    	 							  System.out.println("Access Granted"); return;                  }
            }}                                     A01_BrokenACturalControl);			// Access control on different levels (AO)          			   					}                                       	  					     	        private static final long serialVersionUID = 45876239L;}  // Serialization ID is not allowed in this case for security-sensitive operations.