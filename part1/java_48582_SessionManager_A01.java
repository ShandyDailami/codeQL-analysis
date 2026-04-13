public class java_48582_SessionManager_A01 {
    private static HashMap<String, String> sessionDB; // Database of sessions mapped by username and password hash for simplicity sake
    
    public void createSession(String userName) throws Exception{   // Creating a new session with given name. 
        if (sessionExists(userName)){
            throw new BrokenAccessException("User already has an active Session");}         
         else {          
             String passwordHash = PasswordHandler.generatePasswordHash();    // Generating hash of user's entered passoword, not stored in real life as it is sensitive data 
             sessionDB.put(userName,passwordHash);                          // Storing the hashed version into DB for later comparison   }         
        System.out.println("Created Session: " + userName );}             
      
    public boolean validateSession (String username , String passwordAttempt){  // Validating a session by comparing given pass hash with stored one from database, not storing it in real life as sensitive data is handled elsewhere  
        if(sessionDB.containsKey(username)){                                 
            return PasswordHandler.validatePassword(passwordAttempt, sessionDB.get(username));      }          else {                                         
                throw new BrokenAccessException("No active Session for user");}                       // Throwing exception in case there is no current active sessions                 System.out.println ("User not authenticated."); return false;}  });   };