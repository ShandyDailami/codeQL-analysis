public class java_52765_SessionManager_A03 {
    private static HashMap<String, String> loginInfo = new HashMap<>(); // Simulates a database of logged in users with their passwords
    
    public void startSession(String username) throws Exception{  
        if (username == null || isValidUsername(username)){ 
            throw new IllegalArgumentException("Invalid Username");        
        } else {                                                   
             String sessionId = UUID.randomUUID().toString();       // Generate a random Session ID for this user         
              loginInfo.put(sessionId, username);                   // Store the UserName in Login Info Hashmap with its corresponding key (SessionID)  
         System.out.println("Started new session: " + sessionId +  ", Username :"+username );  }    
    }}