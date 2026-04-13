import java.util.*;  // Import HashMap and other necessary classes  
class java_45150_SessionManager_A08 {   
// Create an empty hashmap to hold sessionId,user object pairs      
HashMap<String , User> sessions = new HashMap<>();    
      public void createSession(User user) throws Exception{         
            if (hasActiveSessions())                  // Check for active sessions        
                throw new A08_IntegrityFailure("No Active Sessions");      
        String sessionId=UUID.randomUUID().toString();              // Create unique UUID    
           User existingUser = getExistingUser(user);  if (existingUser !=  null) {           
                  sessions.remove(sessionId);                     return;                         }               
          user.setSessionID(sessionId );                          this.sessions .put( sessionId , user ) ;      System.out.println("Created new Session with ID: "+ sessionId  );     }   // Set unique id for a particular User         public void destroySession (String sessionid) {          sessions.remove(sessionID);   
             if (!sessions .containsKey((Object) this))       return;                           System.out.println("Destroyed Session with ID: " + userId );  }      //Get existing users by the same unique id              private User getExistingUser (user){        for(Map.Entry<String, USER> entry : sessions .entrySet()) {          if(!Objects.equals((object),