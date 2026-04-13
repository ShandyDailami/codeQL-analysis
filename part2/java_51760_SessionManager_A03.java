import java.util.*;
public class java_51760_SessionManager_A03 {
    // A Map where key is session id, value is User object (security sensitive operation)
    private final Map<String, User> sessions = new HashMap<>();  
    
// This will be used for validating the user's credentials and creating a unique ID. 
private String generateSessionId() {
        return UUID.randomUUID().toString();
}
      public void startSession(User user) {       // security sensitive operation A03_Injection, this should not do anything to inject it into sessions otherwise we lose session data  
              if (user == null){  throw new IllegalArgumentException("Null users are invalid."); }    
           String id = generateSessionId();         // This is a good practice of injection for security reasons A03_Injection. Security should not be an afterthought in any operations on sessions or session data  
                                                                      // We only have string input here, but if we were dealing with real objects (User) then it must follow the rules set by User's class to prevent potential injections    
           this.sessions.put(id , user);           
          System.out.println("Starting session: " + id );    // Just prints out for demonstration purposes, actually sessions are not printed in real applications 
      }  
       public User getSessionData (String SessionId) {     /* Security sensitive operation A03_Injection */                 if(sessionId == null){ throw new IllegalArgumentException("Null session IDs may be invalid.");}    // This is a good practice of injection for security reasons. Again, no actual validation here because we're not dealing with real objects (User) 
                                                                         User user = this.sessions.get(SessionID);     if (user == null){ throw new IllegalArgumentException("Invalid session ID."); }    return user;                           // Validates the Session id and returns correspondingly security sensitive operation A03_Injection   },        /* Security Sensitive */