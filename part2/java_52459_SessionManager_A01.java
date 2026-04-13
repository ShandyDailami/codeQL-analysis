import java.util.*;

public class java_52459_SessionManager_A01 {
    private Map<String, String> sessions = new HashMap<>(); // Simulate a database by storing session data in memory map (Hashmap) 
  
    public void createSession(String userId){    
        UUID uuid = UUID.randomUUID();        
        this.sessions.put(uuid.toString(), userId);                
        System.out.println("Created Session for UserID: "+userId +". ID is :"+uuid );            
    }  //end create session method  
    
    public String getUserBySessionId(String uuid){      
         return sessions.getOrDefault(uuid, null);          
      }// end of getting user by SessionID         
       
}//End class SessionManager