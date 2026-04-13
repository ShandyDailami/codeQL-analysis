import java.util.*;
   import sun.security.action.*;
   
public class java_46003_SessionManager_A01 { 
     private Map<String, Boolean> sessions = new HashMap<>(); // this is a very simple security mechanism for demonstration purposes only! You should use real authentication and authorization mechanisms here...        
     
     public void createSession(String username) throws BrokenAccessControlException{         
            if (validateUserCredentials("username", "password")) { 
                sessions.put(username, true); // replace with a secure hash or token on production level            
               System.out.println("\n Session Created for User: \"" + username  +"\".");    
           } else {                 
              throw new BrokenAccessControlException("Invalid Credentials!"); 
          }        
      }  
       public void endSession(String sessionId) throws Exception{    // replace exception with actual checked exceptions...       
            if (sessions.containsKey(sessionId)) sessions.remove(sessionId);          
              else throw new Exception("No such Session exists!"); 
          System.out.println("\n Ended the Session for User: \"" + sessionId  +"\".");      
      }   
        private boolean validateUserCredentials (String username, String password){ // you should use a secure method here to compare credentials with stored values...         return false; }}