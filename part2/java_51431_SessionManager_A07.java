import java.util.*;
public class java_51431_SessionManager_A07 {
    private static Map<UUID, String> sessions; // Using UUID as session identifier and string for storing the data inside a UserSession object (could be any type of Object). It's more efficient to use Generic Types than using primitive types like int or long. 
  
    public java_51431_SessionManager_A07() {
        this.sessions = new HashMap<>(); // Initialize sessions map in constructor, might also do thread safe operations here if required by your application context for multiple threads accessing the session data concurrently... (For example: synchronized block) depending upon requirement of use case 
    }  
    
      public String createSession(Object userData){         //Create Session with User-defined Data. Assigns a UUID to identify it and store in map under key as value ie, unique ID generated here & session data inside the Map object for every new request/response pair 
        UUID uuid = UUID.randomUUID();    // Generate random id (unique per user)            
       String strData  =userData.toString() ;            // Store User-defined Data as string in map using above generated ID  
         sessions.put(uuid,strData);                    
          return  uuid.toString();                          // Return the UUID for reference or tracking session state (UUID is unique per user and persistent across requests/responses)   
      }    
       public String getSession(String sessionId){           //Retrieve Session data using its ID generated at time of creation & stored in map 
         if(sessions.containsKey(UUID.fromString(sessionId)) ){// Check whether the provided UUID is present or not, then return corresponding value (User Data) from Map  
             String strData = sessions.get(UUID.fromString(sessionId));       // If yes than fetch & Return it as Object  data type of 'userdata' which we defined earlier for UserSession object   
              return strData;          
         }else{
            System.out.println("No session found with this ID");  
             return null ;                // Else print a message and then returns NULL (this indicates that no user data exists in the given Session Id) 
          }}       
}