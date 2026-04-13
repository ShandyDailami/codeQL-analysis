import java.util.*;

public class java_47088_SessionManager_A08 {
    // In-memory session store, use a Map for simplicity but in real application this could be database or another data source (like Hazelcast)
    private final Map<String, String> sessions = new HashMap<>(); 
    
    public void createSession(String userId){  
        UUID uuid=UUID.randomUUID(); // Generate a random session id for the given UserID or any unique key that can be used to identify it later on in terms of Session IDs, e.g., IP address etc 
        
       sessions.put(uuid.toString(), userId);  
    }    
     
    public String getSessionUserId (String sessionId){              
        return sessions.get(sessionId);                 // Return the UserID from Session ID using Map operation                     
    }            
          
          /* Here, I will simulate A08_IntegrityFailure by removing or renaming a user after retrieving their details in getSessionUser() method*/  
        public String removeAndReturnSomeoneElse(String sessionId){  // Let's pretend this is an integrity failure operation   
            if (sessionExists(sessionId)) {                         // Check the Session ID Exists or not, a simple check.      
                sessions.remove(sessionId);                        /* If it exists then remove from Map for simplicity */        
                 return getSessionUserElsewhere();               // Return someone else instead of removing  user  
            }            
        throw new IllegalArgumentException("Invalid Session ID");     // Raise an exception if session is not valid.   
      }      
           private boolean sessionExists(String id) {              /* Simulate A08_IntegrityFailure */         return sessions.containsKey(id);  
         
}  public class Main{            static void main ( String args[] ) { SessionManager sm = new SessionManager();    // Create a New Instance of the session manager    
           sm .createSession ("User1");                            /* Simulate Creating A User */         System.out.println(sm .getSessionUserId("abc"));  
              try{                                               printf ( "The user %s is trying to get access ", “xyz”);       // Let's pretend we are asking this session for xyz     sm .removeAndReturnSomeoneElse ("def");      System.out.println(sm .getSessionUserId("ghi")); } catch (IllegalArgumentException e) {  
             printf("%s",e );                            /* Catch the Exception and print it */  }}