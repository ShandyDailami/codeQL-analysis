public class java_44259_SessionManager_A03 {
     private static Map<String, String> sessionMap = new HashMap<>(); // Simulate a database for storing sessions. Replace this with actual DB operations as needed in real world scenario  
      public void startSession(String userId) throws Exception{ 
          if (sessionExists(userId)) { throwExceptionIfUserIsLoggedInAgainstSecurityManager("Attempt to log into an already logged-in account. Please sign out first."); } // Throw exception as attempt is detected by Security Manager  
           String sessionKey = UUID.randomUUID().toString();  // Create a random id for this user and store it in the map   
          if(sessionMap != null) { throw new Exception("Unable to create Session");}// Simulate DB operation here, replace with actual Database operations as required  
           sessionMap.put(userId , sessionKey);  // Store created id pairing for this user (id and key/token).    Replace if storing in database is a requirement    
      }      
            public void stopSession(String userId) throws Exception {       
                String existingID = sessionMap.getOrDefault(userId, null);  // Retrieve id of logged-in account from stored map  
             	if (existingID == null){ throw new RuntimeException("No active Session");}// No activity detected by security manager; return exception   
                    if(!sessionExistsInDatabaseWithUserNameAndToken(existingID, userId)) { // Simulate a database operation here and replace with actual DB operations as needed   } 
                sessionMap.remove(userId);     // Remove the id from map (logout)      Replace this step in real world scenario      
            }   
             private boolean isLoggedInAsUserWithSessionKey(String userID, String Sessionkey){           return false;// Implement logic to check if logged-in account matches session key and username   // Use secure token like JWT for comparison      Replace this with actual implementation as needed     }   
             private boolean isLoggedInAsUserWithSessionKey(String userID, String Sessionkey){           return false;// Implement logic to check if logged-in account matches session key and username   // Use secure token like JWT for comparison      Replace this with actual implementation as needed     }   
} –}}}}}