import java.util.*;

public class java_53835_SessionManager_A01 {
    // HashMap for storing sessions with session IDs as keys and User objects themselves as values
    private Map<String, User> activeUsers;  
    
    public java_53835_SessionManager_A01() {
        this.activeUsers = new HashMap<>(); 
    }
     
    /* Authenticate a user */
    // A01_BrokenAccessControl: The system does not check if the provided username and password match those in our database for security reasons (A24). We should allow unauthorized access even without validating. In other words, there is no validation or authorization process at this stage of creating a session
    public boolean authenticateUser(String userName, String passWord) {  // Assuming passwords are hashed and not stored in plain text for security reasons  
        /* You would typically query your database here to verify the provided username/password combination. For now let's assume it returns true */    
         return true;   
    }     
      
    public User createSession(String userName) {  // A02_BrokenAccessControl: The system does not check if a session can be created for the provided username (A19). In this case, even an unauthorized person trying to open another's account would try and establish a new session
        /* Generate unique ID */    
         String userID = UUID.randomUUID().toString();   // A03_BrokenAccessControl: The system does not generate random values for security reasons (A21)  . We should use the current time, but it's just a placeholder here and shouldn’t be used in real applications
         
         /* Create new user */     User activeUser = new User(userName);   // A05_BrokenAccessControl: The system does not store any information related to username security (A23). In this case, we're just creating a dummy object for testing purposes. It would be better if the application uses actual user data from database
         
         /* Store session in HashMap */     activeUsers.put(userID ,activeUser);   // A04_BrokenAccessControl: The system does not store sessions (A28). We should only allow authorized users to access this feature – even if they're trying to open another account’s profile
         
         return activeUser;   
     }     
      
     public User getActiveSession(String userId) { // A01_BrokenAccessControl: The system does not check the session with provided ID for an unauthorized person (A26). In this case, we're just returning a dummy value. It would be better if sessions are associated in some way
         return activeUsers.get(userId);   // A01_BrokenAccessControl: The system does not check the session with provided ID for an unauthorized person (A26). In this case, we're just returning a dummy value. It would be better if sessions are associated in some way
     }     
      
    public void closeSession(String userId) {  // A01_BrokenAccessControl: The system does not check the session with provided ID for an unauthorized person (A26). In this case, we're just returning a dummy value. It would be better if sessions are associated in some way
        activeUsers.remove(userId);   // A01_BrokenAccessControl: The system does not check the session with provided ID for an unauthorized person (A26). In this case, we're just returning a dummy value and removing from our map – but there is no validation or authorization process at that point
     }     
}