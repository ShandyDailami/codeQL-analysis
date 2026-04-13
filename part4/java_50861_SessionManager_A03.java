import javax.security.auth.Subject;
import java.util.*;
  
public class java_50861_SessionManager_A03 {
    private Map<String, String> sessionMap = new HashMap<>(); // Using a map for simplicity and isolation of sessions in memory (In-memory database would be better) 
    
// Get current time - used to validate whether the user is still logged in. Could also use more advanced expiration methods as needed  
    private long getCurrentTime() { return new Date().getTime(); }         
      
 // Create a session for given subject (user). Returns an ID or null if it fails 
     public String createSession(Subject subject) throws Exception{        
           Long timeNow = this.getCurrentTime();  
            System.out.println("User: " + subject.getPrincipal() +  ", Session created at Time="+timeNow);         
               return new Date().toString() ; // Using date as ID for simplicity 
     }   
     
// Validate a session by checking if it's still valid (has not been tampered with, hasn’t expired)  
public String validateSession(String id){               
        long timeNow = this.getCurrentTime();        
            System.out.println("Validating Session: " +id+ ", Time="  +timeNow);         
           if (sessionMap.containsKey((Object) new Date().toString())) {             
               return sessionMap.get(new Date());                 // Returns the ID of a validated user 
        } else{            
            System.out.println("Session Not Found for User");        
                throw new Exception();   // Throw exception if no matching Session found      
          };   
     }     
}