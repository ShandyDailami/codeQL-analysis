class java_52322_SessionManager_A01 {  // Start with `public class` keyword, followed by name in CamelCase notation (CamelCase is good for naming conventions)  
    private static Map<String, String> sessionMap;    
     
    public void startSession(String userId){         
        if(!sessionExistsForUser(userId)){              // Checking Session doesn't exist. Start a new one            
            createNewSessionCookieAndStoreInDbOrHashmapBasedOnJWT(userId);           }   else{               console.log('Error: User is already logged in');  }}     private boolean sessionExistsForUser (String userID){// Return `true` if a Session for the provided ID exists, otherwise return false}
      // ... Add other utility methods that your program will need here such as creating new JWTs or checking token validity.   }           @javax.management.timer.TimerHandle runEveryXMinutes (int min){  while(true) {console.log('Running every ' + minutes);         try{createNewSessionForAllUsersInDb();}catch{}finally {}return null;}