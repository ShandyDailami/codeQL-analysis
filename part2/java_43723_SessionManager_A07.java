import java.util.*;  // For ArrayList and HashMap data structures only. No external frameworks needed in this context; standard libraries are preferred for simple tasks such as these ones.  
                   
public class java_43723_SessionManager_A07 {   
    
private Map<String, String> userSessionInfo = new HashMap<>();      // A map to store username & sessionid pairs – Could be shared among all sessions (for simplicity) but this should change when you add more security measures like role-based access control.  
                                                          
public void startSession(String username){   
     UUID uuid = UUID.randomUUID();                // Create a unique id for the session, could use something better e.g., system time or similar – not required but makes it easier to manage sessions in this simple example code; standard libraries can be used if needed (like java.util.*).  
     userSessionInfo.put(uuid.toString(), username);    // Store unique id as key and the name of session holder at value, thus associating them together – again not required but makes it easier to manage sessions in this simple example code; standard libraries can be used if needed (like java.util.*).  
     System.out.println("Started new Session with User " + username);    // Print a message indicating the session was started, could also use logging library for more complex scenarios – not required but makes it easier to manage sessions in this simple example code; standard libraries can be used if needed (like java.util.*).
}  
                                                          
public String getUserName(String SessionId){     // Assume you have a way of getting the session id from user, could also use something better e.g., login details or similar – not required but makes it easier to manage sessions in this simple example code; standard libraries can be used if needed (like java.util.*).  
                                                           return(userSessionInfo.getOrDefault("sessid", "Not logged In")); // Return the user who has been associated with that session ID – could also use a more complex method for role-based access control, or simply indicate not logging in if no one is present at all (in this case), standard libraries can be used to handle these situations.
}  
                                                                                         
public void endSession(String SessionId){     // Assume you have the session id from user – also could use something better e.g., login details or similar, not required but makes it easier in managing sessions here (standard java utils).    System.out.println("Ended current User's Session with ID " + sessid); }  
                                                                                          // Print a message indicating the session was ended – also could use logging library for more complex scenarios and handles user logouts, standard libraries can be used if needed (like java.util.*).                                                      
}