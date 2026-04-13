import java.util.*;   // Importing necessary Java standard libraries for HashMap, UUID etc..   
public class java_48814_SessionManager_A03 {    
       private static final Map<String, Object> sessionData = new HashMap<>();     
        public String createSession(Object data) {            
            String uuid = UUID.randomUUID().toString();         // Creating a random unique ID for each user         
            sessionData.put(uuid ,data);                      // Storing the login details in hash map with respective key (id).  
                                                             // Here, we are storing only 'Object' data type which may carry sensitive information     
                                                                  and not recommended to store actual objects here    
           return uuid;                                      // Returning session id.   
        }        
       public Object getSessionData(String SessionId) {         
            if (sessionData .containsKey(SessionId)){             /// Check the key whether it exists in hash map or not, and also 
                System.out.println("Found a valid user: "+ sessionData);   // Logs for debugging   
                 return sessionData.get(SessionId) ;         }           
           else {                                             
             throw new IllegalArgumentException ("Invalid Session");     /// Throws an exception in case of invalid sessions     
          }}