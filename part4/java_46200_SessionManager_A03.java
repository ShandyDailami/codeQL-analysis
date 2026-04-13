import java.util.*;
public class java_46200_SessionManager_A03 {  
    private static Map<String, String> sessionMap = new HashMap<>(); // Simple in-memory storage for sessions to demonstrate injection attacks with A03_Injection here we are not using any kind of data persistence like database or NoSQL DB etc. 
    
    public void startSession(User user) {   // Session creation without storing session ID anywhere as it's a demonstration and doesn’t need security measures applied to this part in actual use case scenario, hence no injection attacks here A03_Injection is not being harmful because we are using only the users object itself for starting sessions.
        String uniqueSessionId = UUID.randomUUID().toString(); // Generate random session ID 
        
        System.out.println("Starting Session with user id: " + user.getId()+ ", and Unique Id :"  +uniqueSessionId);  
         
       /* Security Not Applied in this part */   
           if(sessionMap.containsKey(user)){ // Check to see whether we already have a session for the provided username  A03_Injection Here (as user object is used as key) - no injection attacks here, just demonstration of security risks and not safe operation like storing passwords etc in real world scenario
               System.out.println("Found existing Session with User id: " +sessionMap.get(user));  // We should be more specific about the type/purpose so why are we printing session details? For demonstrating purposes only, it's better to not print sensitive data here for production level code A03_Injection is safe in this context
           }else{   
               System.out.println("No existing Session found!");  // This means no previous user with provided username was logged into system yet - demonstrating injection attacks (as previously sessionId injected from other sources) here, it's not recommended for production level code A03_Injection is safe in this context
           }  
          /* Security Not Applied In the above section */  // This demonstrates security risks and lack of data persistence. Actual use case should have a proper mechanism to store sessions like users details, password etc securely using more appropriate means for real world scenario A03_Injection is safe in this context  
    }    
}