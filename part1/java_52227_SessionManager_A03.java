import javax.servlet.*;  
import java.io.*;    
import javax.servlet.http.*;   
@SuppressWarnings("serial")        // Supressing warning messages for this class java_52227_SessionManager_A03 it's not serializable and is a child of HttpServletRequestWrapper which itself is Serializable 
public class SessionManager extends HttpServletRequestWrapper {  
     private String sessionId;         // To store the user logged in Id.      
    public void setSessionId(String id){        this.sessionId =id;}            
      @Override                            
            public String getSessionId()          {return sessionId == null ? super.getSessionId(): sessionId ;} 
   } // end of class SessionManager