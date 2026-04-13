import java.util.*;
public class java_50150_SessionManager_A07 {  
    private static HashMap<String, String> userSessions; // session id --> UserName    
     
       public java_50150_SessionManager_A07() {          
            this.userSessions = new HashMap<>();        
              } 
              
             /* Method to create a Session for the given username */   
   private String createSession(String user)                    
                 {                                                      
                   // Create session, store UserName in it and return ID (UUID recommended).                 
                        UUID uuid = UUID.randomUUID();       
                          this.userSessions.put(uuid.toString(), user);                                       
                               System.out.println("Session created for " + user   + ". SessionID :"  +   uuid );                      
                           return  uuid.toString() ;           
                 }     
               /* Method to check if a session exists and belongs to the given username */    
              public boolean validateUserSession(String sessionId, String usernameToCheck)             {   
                    // Check in userSessions Map whether this SessionID is mapped with correct UserName.                     
                           return (userSessions.get(sessionId).equals(usernameToCheck));                } 
               /* Method to terminate/close a previously established session */    
              public void closeSession(String sessionId)             {        // This method should be used only when necessary, not in real-world applications            System.out.println("Closing Session " +sessionID);                                                      this.userSessions.remove(sessionId);                                                                                }         
}  /* End of SecurityManager Class */               public static void main (String args [])           {                  SecurITYSessionMAnAGER sm = new SECURITYSESSIONMANAger();                 SM .createSEsion("John");        // returns SessionID "e9f8a726-b413-4d5c-bd08-bcafec4efdd8" 
                  System.out..println(SM_.validateUserSession (" e9fa... , SM"));       return; }}    } /* End of Main method */      SECURITYSESSIONMANAGER_HASBEENLOADED} // The class name has already been loaded by the Java Runtime Environment (JRE)