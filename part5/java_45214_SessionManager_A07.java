import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_45214_SessionManager_A07 implements HttpSessionListener, ServletContextListener {
    private static final long serialVersionUID = 1L;
    
    // This method is called whenever a new session has been created by the HTTP server and before any request/response processing for that session occurs 
    public void sessionCreated(HttpSessionEvent event) { 
        HttpSession session = event.getSession();  
	System.out.println("New Session Created : " +session.getId());     
     }      
        
 // This method is called whenever an existing session has been invalidated by the HTTP server and before any request/response processing for that 
// instance occurs if this servlet only ever sets a cookie with a very short expiry value (typically one second)  
    public void sessionDestroyed(HttpSessionEvent event) {      System.out.println(" Session " +event.getSession().getId()+" has been destroyed");     }      
}