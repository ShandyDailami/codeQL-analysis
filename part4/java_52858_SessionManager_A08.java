import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
// Importing HttpServletResponse for HTTP response methods and Cookie handling

public class java_52858_SessionManager_A08 implements Servlet {  // Defining a new servlet called "Session Manager" in Java
    public void init(ServletConfig config) throws ServletException {}  	// Init method not used here, but required by interface.    	
                                                                        // This is just to be able of the de-facto destroy() call on this object 		               					      			                                                  				              								         }) {    }      // Destroy Method Not Used Here But Required By Interface - Do NOT REMOVE THIS METHOD, JUST FOR DEFACTO CLEAN UP
    	   public ServletConfig getServletConfig()	{ return null;	}	// Returning Null as not required in this case. This method is only for getting the configuration of a servlet 	   		        // And hence can be safely ignored if we are doing so by using methods defined here, like init().
    	   public void service(ServletRequest req, ServletResponse res) throws ServletException {}   	// Service Method Not Used Here But Required By Interface - Do NOT REMOVE THIS METHOD. This method is only for handling HTTP request and response 	   		        // And hence can be safely ignored if we are doing so by using methods defined here
    	   public String getServletInfo() {return "Session Manager";}	// Returning Information about servlet like its name, version etc... (Not Used Here)      									                                                            })      return null;  } // Method Not used in this case but must be present to fulfill the interface requirements.
    	   public void destroy(){// Destroy method not required for session manager as it is a simple example}	// This would typically involve cleaning up any resources allocated during construction of servlet such as database connections etc... (Not Used Here)   		        // But can still be ignored if we are doing so by using methods defined here.
    	    public void doPost(HttpServletRequest request, HttpServletResponse response){}  	// Do not forget to add a method for handling POST requests in your servlet which will handle session creation and destroying 	http://.../session-manager?action=create or http://...../session-manager?action=destroy
    	    public void doGet(HttpServletRequest request, HttpServletResponse response){}  	// Add more methods for handling GET requests if necessary. (Not Used Here)   		        // But can still be ignored as this is just a basic session manager example with no additional functionality 	 	http://.../session-manager?action=create or http://...../session-manager?action   
}