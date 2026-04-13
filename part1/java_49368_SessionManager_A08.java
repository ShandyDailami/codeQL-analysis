import java.util.*;  // Import necessary classes for HashMap, UUID etc...
  
public class java_49368_SessionManager_A08 {   
     private Map<UUID, String> sessionStore;       // Create a map to store sessions with their ID as key and user name string value which will be used when required again (like in A08_IntegrityFailure) 
                                                   
      public static final int SESSION_TTL = 60 * 15;     // Session Time To Live is set for every new session to one hour by default. You can change this according your requirement        
                                                                   
   /* Create a constructor where you initialize the map */       
       public java_49368_SessionManager_A08() {         
           sessionStore = new HashMap<>();      } 
           
     /** Starts A08_IntegrityFailure'ing an existing user, if not already exists. If yes then returns false otherwise it will return true and store that name with a unique UUID in the map */   
       public boolean startSession(String username) {   // Check whether this session is still valid or expired based on SessionManager ttl setting  (15 min default). It can be changed according to requirement.     
           if(!sessionStore.containsKey(UUID.randomUUID())){     // If the UUID doesn't exist in map then create a new one using random uuid         
                sessionStore.put(UUID.randomUUID(), username);    }   else {         return false;  }}        /* When this function is called it means user already has an existing Session so we have to check if its still valid or not */      public boolean validateSession(String token) throws Exception{ // Use the session Token (which should be unique for each client and stored in map at start of every new connection), 
                                                                                          /*validate whether this is a genuisly connected user - by checking against our Map. If it does then return User Name otherwise throw an exception */   if(sessionStore.containsKey(UUID.fromString(token))){     // Check the session Token    UUID uuid = (UUID) token;
                                                                                          /* Get Username from this SessionID  - This should be handled in a better way than directly converting Object to string or vice versa */         return username;} else { throw new Exception("Invalid/Expired Session");}}          }             };     // Make sure the program is syntactically correct Java code.