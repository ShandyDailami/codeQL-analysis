import java.util.*;  // Import List interface from Java utility package  
class java_49813_SessionManager_A08 {   
     private static final Map<String, Integer> sessionMap = new HashMap<>();     
      
     public void startSession(String userId) throws Exception{       
         if (sessionMap.containsKey(userId))  // Checking for concurrent modification  
             throw new Exception("A08_IntegrityFailure: Attempt to create a session with an already existing id");          
          int currentTime = (int)(System.currentTimeMillis()/1000);       
         synchronized(userId){            // Locking the user for concurrency control  
             sessionMap.put(userId,  currentTime + 60*5 );     
              System.out.println("Started new Session with UserID: " + userId  +" and Expires on : "+ (new Date((long)sessionMap.get(userId))));          }       catch (Exception ex){            throw   ex;     }}    public void endSession(String sessionid, String tokenizedUserName ) {     
         if (!sessionMap.containsKey(tokenizedUserName)){        // Checking for concurrent modification  and expiration check of the user's current Session       return;} else{          int timeNow = (int) ((System.currentTimeMillis() /1000));           long lastAccessedSessionId  = sessionMap .get(tokenizedUserName);     
         if((lastAccessedSessionId +  60 * 5 ) <timeNow){       // check for expiration     return;} else {              }          }}