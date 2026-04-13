import java.util.*;
public class java_53895_SessionManager_A03 {
    private static Map<String, String> sessions = new HashMap<>();  // simulate session storage in memory  
    
    public void startSession(String userName) throws Exception{      
        if (userAlreadyLoggedIn(userName)) throw new Exception("User already logged out");           
        
        synchronized(this){          
          String uniqueId = UUID.randomUUID().toString(); // generate a random id for each session 
                                        
          sessions.put(uniqueId, userName);    // save the mapping of login ID to User name in Session storage  
                                                      
          System.out.println("Started new session: " + uniqueId );          
        }    
        
       setUserSessionInCookie(uniqueId);  // store this id server-side for user's browser by setting a cookie   
                                        /* or send it in response header */     
   }
                   
   public void endSession(String sessionID) throws Exception{                  
        if (!sessionExists(sessionID)) throw new IllegalArgumentException("No such Session");           
        
       synchronized (this){                  // prevent other threads from modifying sessions while we are accessing them 
           System.out.println ("Ended the session: " + sessionID);            
          sessions.remove(sessionID );   // remove this entry in our mapping of user names to their IDs    
                                  /* or forget it by clearing cookie */     
       }                                  
    }                                                 
  private boolean setUserSessionInCookie (String id){                       // store session identifier server-side for the browser's cookies                    
          System.out.println("Setting a Cookies");                          
         return true;                                            
   }    
            
  public String getLoggedUsername(String uniqueId) {                        /* retrieve username from SessionID */          
       if (!sessionExists(uniqueId)) throw new IllegalArgumentException ("No such session id exists.");            // check the existence of this ID   
                return sessions.get (uniqueId);   // fetch user's name based on a generated server side unique identifier 
     }         
      private boolean sessionExists(String sid) {                         /* Check if Session is valid */          
        synchronized (this){                                              // lock the method to prevent other threads from modifying sessions while we are checking them  
            return sessions.containsKey (sid);                           /// simulate hashmap's containskey operation with thread safety using 'synched block'. If this session id is valid, it will be returned true otherwise false     
        }                                                            // if the Session ID exists then returns True else False    .              synchronized(this){         return sessions.containsKey (uniqueId);   }}  */     System.out.println("Session Exist: " + sid );                   /* Synchronization is added to avoid concurrent modification exception on checking session existence in a multi-threaded environment*/