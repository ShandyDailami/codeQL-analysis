import java.util.*;  // for HashMap, UUID etc... and all other standard libraries you are allowed to use only in this program (not including external dependencies)

public class java_52175_SessionManager_A08 {  
    private Map<UUID, String> sessions;     // We'll store the session ids as strings due to simplicity here. In a real app these would be UUID type instead and potentially encrypted for safety reasons 
                                           // but this program does not consider that scenario in its implementation (security related code).  
       
    public java_52175_SessionManager_A08() {                
       sessions = new HashMap<>();           
     }                                    
     
    /** Creates a session. */                             
    UUID createSession(String user)  throws Exception{             //We are throwing exception here as it is not in real scenario but for illustration purpose  
        if (user == null || user.isEmpty()) throw new IllegalArgumentException("User can't be empty");    
        
       sessions.put(UUID.randomUUID(), user);                      // A random UUID and the username should always generate a different id, hence it is not in real scenario 
                                                                   /* but for illustration purpose */         
        return UUID.randomUUID();                                  // We are returning newly created session's ID here since we can just create one without any logic to assign same or similar user another Session    
    }                                                            
        
       /** Returns the username of a given session id if valid, otherwise null (i.e., invalid sessions will return 'null'). */   //We are returning String type due to simplicity here but in real application it should be UUID and we can check with our own logic whether this is really Valid Session or not     
       public  String getUser(UUID sessionId) {                 
           if (sessionExists(sessionId)) return sessions.get(sessionId);    //This could throw NullPointerException for a non-existent key but in real application, we should be more robust by checking the existence of keys or use 'sessions' method which throws IllegalArgumentException when such session doesn’t exist
           else  {                                                      /* This part is not included due to simplicity. In practice you need something like HashMap::getOrDefault() for this case */   //This will be handled in real application as it involves checking the key existence and handling 'null' scenario     return null;    }     
       }}