import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("customSessionManager") // unique id to refer this manager in other places, could be a bean name or any string (for autowiring) 
public class java_47114_SessionManager_A01 {  
    
    public void startSession() throws Exception{        
        SecurityContextHolder.getContext().setAuthentication(null);         
           /* In real world scenarios: A session object is created here with necessary data and saved in a database or other persistent store */           
    }  // end of 'start' method  
      
     public void stopSession() throws Exception{        
        SecurityContextHolder.getContext().setAuthentication(null);         
           /* In real world scenarios: A session object is removed here when it has been closed or expired and the objects are deleted from persistent store */           
    }  // end of 'stop' method  
}