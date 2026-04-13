import java.util.*;
public class java_42808_SessionManager_A08 {    
    private Map<String , String> userMap; // Simulated User data store for demonstration 
      
      public void createSession(String username){         
        if (username == null || username.isEmpty() ){           
           throw new IllegalArgumentException("Username cannot be empty");               
         }             else {                 
               String sessionId = UUID.randomUUID().toString();              // Generate a random Session id   
                   userMap.put(sessionId,username);                          // Store the username and its corresponding ID in Map     
                 System.out.println("Created new User ["+username + "] with unique Id:["+  sessionId +  "]. Current list of Users:"  +userMap );       }        }}