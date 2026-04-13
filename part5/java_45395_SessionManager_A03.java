import java.util.*;  // Import Hash Map Collection Framework  
                   /* Here we use only standard library classes */       
public class java_45395_SessionManager_A03 {    
    private static final long VALIDITY_TIME = 10 *60*1000;      // validity time in milliseconds (for example: 10 minutes)        
                                      /** Map that stores user sessions. Key is session ID, Value is the actual User object */  
        protected HashMap<String ,UserSession> mapSessions = new HashMap<>();   
          /* We only use standard libraries for this purpose - no external frameworks here*/ 
       //------------------------//     constructor and methods to manage sessions.      //----/        
           public java_45395_SessionManager_A03() { }  
        /** Create a session */                
               protected String createSession(User user)    {          /* No SQL Injection Vulnerabilities on this method - so no comment added*/ 
                       UUID uuid = UUID.randomUUID();       // Generate random unique ID for each new Session           
                      mapSessions .put (uuid.toString(),new UserSession((user),System.currentTimeMillis()+VALIDITY_TIME));      /* Store session in Map with Key as the generated Random Unique string and Value is a user-specific data object*/         return uuid.toString();  }  
        /** Check if Session ID exists */                  protected boolean hasSession(String sid) {            // No SQL Injection Vulnerabilities here, we just use Map keys    mapSessions .containsKey (sid);      /* Returns true only when the session id is present in our HashMap*/ }  
        /** Get Session Object by its ID */                  protected UserSession getSession(String sid) {            // No SQL Injection Vulnerabilities here, we just use Map keys    return mapSessions .get (sid);       /* Returns the session if it exists otherwise throws NullPointerException*/ }  
        /** Destroy Session by its ID */                     protected void destroySession(String sid) {            // No SQL Injection Vulnerabilities here, we just use Map keys    UserSession us = mapSessions .get (sid);     /* Retrieve the user data from our session*/  if ((us != null ) && (!isExpired((Long)(mapSessions.get(sid).creationTime()))){   // Check Session Expiration      
            System.out.println ("Session Destroyed with ID : " + sid);         mapSessions .remove (sid );} }  /** Validate if a session is still valid */      protected boolean validateSessionId(String sid, User user) {          /* No SQL Injection Vulnerabilities here - no comments added*/    return ((mapSessions.containsKey((sid))) && (!isExpired (Long .parseLong  
            (.format ("%d", mapSessions.get (sid).creationTime))))); }     /** Check if a session is still valid */      protected boolean isValidSession(String sid, User user) {          /* No SQL Injection Vulnerabilities here - no comments added*/    return ((mapSessions .containsKey((sid))) && (validateSessionId  
            (sid ,user))); }  // check if session still valid in terms of time. The validity period for each Session is set by the user when a new User object was created with this method */     protected boolean hasExpired(Long creationTime){ return ((System.currentTimeMillis()-creationTime) > VALIDITY_TIME); }
}  // End class definition - No SQL Injection Vulnerabilities are present here in Java standards (no external frameworks). Only standard libraries used */