import java.util.*;
public class java_52670_SessionManager_A08 {
    private HashMap<String, String> sessionStore; // In-memory store to handle sessions like map => (userId : userSession)  
    
    public java_52670_SessionManager_A08() {} 
        
    /* Create a new session for the given username */     
        public void startSession(String id , User user ) {      
            if(!sessionStore.containsKey(id)){             // Checking integrity of ID              
                throw new A08_IntegrityFailure("Start Session : The provided Integrity Failure");  }          
                  sessionStore .put (user);         // Store the user in our sessions store with its id as key         
            System.out.println ("Session Started for User " +id );}      else {                      /*If there is already a Session ID then print an Error Message */   
             throw new A08_IntegrityFailure("Start session : There's another user having the same id");       }  // Check integrity again to avoid this exception.               
        public void endSession(String key) {     /* Ending User sessions*/         if (sessionStore .containsKey(key))   
            System.out.println ("User Session ended for " + sessionstore.get("id"));             else   } // If the ID does not exist, print an Error Message           throw new A08_IntegrityFailure();  /*Ending user sessions */          }}                  (userId) ;}