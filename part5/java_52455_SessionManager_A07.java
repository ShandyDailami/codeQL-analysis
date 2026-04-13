import java.util.*;

public class java_52455_SessionManager_A07 {    
    private Map<UUID, String> sessionMap; // our sessions are stored here as UUIDs and user id strings (as required)  
                                                                                                                 
    public java_52455_SessionManager_A07() {                          
        this.sessionMap = new HashMap<>();        
    } 
                                     
    /** Create a新的会话 */      
    public String createSession(String userId){          //UUID uuid= UUID.randomUUID ();      --> for creating unique ids in real world scenarios                 
        this.sessionMap.put(UUID.fromString("12345"),userId );  return "Created session";}        
                                                                                                                     
    /** Get the user from a specific session */       // UUID uuid= (UUID)this.sessionMap;          --> for getting data in real world scenarios     
     public String getUserFromSession(String SessionId){                 
        if(! this.sessionMap .containsKey("12345")){                      return null;}                else {return sessionMap.get("12345");}}   // here we are assuming that user id is always the same in every request so it's not a best practice to check for auth failure        
                                                                                                                 
    /** Close an existing Session */  /*UUID uuid= (UUID)this.sessionMap;          --> For closing session scenario                return "Closed sessions";}                 // here we are assuming that user id is always the same in every request so it's not a best practice to check for auth failure        
     public String closeSession(String SessionId){                     this.sessionMap .remove("12345");           /*return ("Removed session with ID: " + uuid);*/}}    // here we are assuming that user id is always the same in every request so it's not a best practice to check for auth failure        
                                                                                                                  }  */