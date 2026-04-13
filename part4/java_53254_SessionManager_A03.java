import java.util.*;  // import Standard Library classes/packages  
class java_53254_SessionManager_A03 {   
     Map<String, String> sessionMap;        // create a Hashmap for storing user sessions     
      
     public void startSession(String username){         
         UUID uuid = UUID.randomUUID();              // Generate unique ID          
         this.sessionMap.put(uuid.toString(),username);    }                
              
   public String getUserName(String sessionID) {      return (this.sessionMap.get(sessionID));     }}