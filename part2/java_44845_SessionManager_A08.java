import org.springframework.security.access.AccessDeniedException;  // Import Access Denied Exception from spring security library if needed (this is for the error handling part)  
public class java_44845_SessionManager_A08 {    
    private static HashMap<String, String> sessionDB = new HashMap<>();       // Database to store sessions and their respective user names. This will be replaced with actual database in real application 
                                                                                // A hashmap stores key-value pairs where value is username for security sensitive operations (A08_IntegrityFailure)  
    public void startSession(String sessionId, String name){    
        if(!sessionDB.containsKey(sessionId)){      // Checking whether the given id already exists in our database or not 
            sessionDB.put(sessionId ,name);       // If it doesnt exist then add to map with key being ID and value username  
                                                                                } else {         // Exception if a user tries starting an existing one          throw new AccessDeniedException("Session already started for this User");    }}  end of checking session id exists in the database