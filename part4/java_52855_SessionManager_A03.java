import java.util.*;  // Import HashMap and others needed below...
public class java_52855_SessionManager_A03 {    
    private static Map<String, String> sessionDB = new HashMap<>();      // Database to store sessions (Insecure)
                                  
    public void createSession(String userId){                          // Insecure method of creating a session                    
        UUID uuid=UUID.randomUUID();                                      // Generate random ID for the Session                             
        String secureToken = encryptToken(uuid);                         // Encrypted Token created based on above generated Random string  
                                                                         // Note: This is not recommended due to lack of encryption or security in place 
                                        sessionDB.put(userId,secureToken );    // Store SecureSession ID against userID (InSecured way)      
     }                                                               
      public String getUserFromSession(String secureToken){             /// Insecures method for getting User based on Session token  
          return  sessionDB.getOrDefault("userId", null);                // Fetching the Secure Token from HashMap (Insecure way)   
        }                                                               
       private String encryptToken(UUID uuid){                          /// Method to Encryption of Generated Random UUIDs  
          return  uuid.toString();                                        // Note: This is not recommended as it's a simple demonstration and lack encryption or security measures    
      }                                                                   
}