import java.util.*;  // Import HashMap, Optional etc...
public class java_47920_SessionManager_A01 {  
    private Map<String, String> sessionDB;     // Database to store sessions ie users and their tokens (userId : token)         
      
    public java_47920_SessionManager_A01() {                     // Initialize the database/session DB 
        this.sessionDB = new HashMap<>();     
    }  
        
    private boolean isSessionValid(String sessionToken){            // Check if user provided a valid and active (i.e., exists in our db) token to access another page or resource                     
           Optional<String> idOpt =  this.sessionDB.keySet().stream()  .filter(k ->  this.sessionDB.get(k).equalsIgnoreCase( sessionToken ) ).findAny();   // If user present then return true, else false                       
        if (idOpt != null && (!this.isSessionExpired( idOpt.get()))){     // Checking token existence and not expiry  -> Return whether exists or valid    Otherwise returns Optional empty which is considered as "false" in boolean context      }   return true;            else {          System.out.println("User Session Expiring/Token has been compromised");return false;}
        }}           // Add exception handling to check if user session already expired, same way you can handle token being invalid or no present at all  (user not signed in etc.)   }               private boolean isSessionExpired(String id){    ...}      public void endSessionForAllUsers(){...}}