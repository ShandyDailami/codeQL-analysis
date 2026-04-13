import java.util.*;
public class java_46737_SessionManager_A08 {  
    private static Map<String, String> credentials = new HashMap<>(); // For simplicity and security reasons stored in memory only for this example; actual usage needs to be secure against SQL Injection or similar attacks    
      
      public void createSession(String userId)  throws Exception{       
          if (userExistsInDatabase(userId)){            
              SessionContext.set("session", UUID.randomUUID().toString());   // Create session and assign a random ID to it           
               System.out.println("Created new User: " + userId);          
         } else {                                                           
                throw  new Exception ("User not found in database");    }}            
    
      public void login(String userName, String password) throws Exception{              // Login method        if (credentialsMatchInDatabase(userName ,password)){               SessionContext.set("session", UUID.randomUUID().toString());           System.out.println ("Logged in User: " + username);         } else {                           throw new  Exception ("Invalid Credential"); }}
     public static boolean userExistsInDatabase (String id){             // Check if the given ID exists          return credentials.containsKey(id );}            Public void setCredentials () {}   @BeforeEach method to initialize a session manager and load test users into database      private SessionManager  sm;    User u1,u2 ;