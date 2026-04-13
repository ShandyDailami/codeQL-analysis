import javax.security.auth.Subject;
import java.util.*;

public class java_45695_SessionManager_A03 {
    // In this example, we will use a simple HashMap to store sessions in memory only for simplicity and performance reasons
     private Map<String, Subject> sessionStore = new HashMap<>(); 
     
   public String createSession(Subject subject) throws Exception{      
        if (subject == null){           // Validation: The user cannot be anonymous or not logged-in. We need to have a valid authenticated 'user' in the system for sessions    
            throw new IllegalArgumentException("No active subjects"); 
        }     
         String sessionId = UUID.randomUUID().toString();   // Creating unique IDs   
          sessionStore.put(sessionId, subject);              // Storing user-subject pair into map (Key: SessionID , Value : Subject)    
           return sessionId;                               // Returns the created sessions id 
       }     
        public void endSession(String sessionId){            
            if (!sessionStore.containsKey(sessionId)){        
                throw new IllegalArgumentException("Invalid or Expired Sesion ID");   
               }     else {                     
                   Subject subject = sessionStore.get(sessionId);      // Fetching the validated user-subject pair  
                    if (null != subject)                            // If it's not null, then remove from map 
                        sessionStore.remove(sessionId);              
                }      
        }    
}