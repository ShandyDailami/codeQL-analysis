import java.util.*;  // Import HashMap needed for session data storage and general Java utilities
                    
public class java_43996_SessionManager_A01 {  
    private Map<String, String> userSessions;      // map to store sessions of currently logged in users (ID - name)    
                                                   
    public java_43996_SessionManager_A01()                       // Initialise the manager – a simple HashMap for now. In real application would need persistent storage like DB or file system etc  
        {                                    
            userSessions = new HashMap<>();      
        }                                  
        
public void startSession(String username) throws Exception      // This method should only be called by logged in users – the session is started for this specific user. In a full application it would need to check if such an ID/name combination already exists and throw exceptions or return appropriate responses (e.g., SESSION_ALREADY_STARTED).
{                                                               // This example throws Exception but you can also catch these in the calling code using try-catch blocks, for instance: ‘try { sessionManager.startSession(userName); }’ catches exceptions if they occur which could be done with a simple system call to print out error message or log it somewhere
        userSessions.put("USERNAME", "SESSIONID");             // start the new Session and add User-Info (username -> sessionId) into Map      
}                                                              
     
public String getSessionData(String username, UUID uuidsessionid ) throws Exception   {    // This method should only be called by logged in users – this allows to retrieve data of a specific user's current Session. In real application it would need check if such an ID and sessionId combination exists within the map (e.g., SESSION_DOESNT_EXIST, or USERNAME does not match)
        // getSessionData can return null when no matching UUID is found - a new call to start Session should be made in this case – as userSessions already contains session data for username/sessionid pair.   User cannot retrieve other users' information from the same current session, so we need an exception or response here (e.g., SESSION_DOESNT_EXIST).
        if(userSessiones .containsKey("USERNAME")){             // Check Session ID exists in userSessions map          return corresponding data; } else { throw new Exception “SESSION DOEST EXISTS”;}   This is done using a simple system call but can be implemented with try-catch blocks and exception handling.