import java.util.*;   // Needed packages   
 
public class java_51951_SessionManager_A01 implements Context {     // Our custom interface for session management     
       private static HashMap<String, String> userMap;          // User map to simulate users' access in a database       
                                                             
       public void start()                                  // Initialize the hashmap        
           throws Exception{                  
               System.out.println("Starting Session Manager...");                 
                       if (userMap == null) {                
                           userMap = new HashMap<>();                    
                               }                         else  throw new SecurityException ("Session manager already started.");                        // If sessionmanager is not active, create a hashmap        
                                                              System.out.println("Started Session Manager Successfully...");   return;     }}                  
       public void stop()                                     {      if(userMap == null)                 
                               throw new SecurityException ("Session manager has already been stopped.");                    // If sessionmanager is not active, do nothing              else  System.out.println("Stopping Session Manager");            userMap =null;               }        return;}   public String getUser(String username){    if (userMap == null) {throw new SecurityException ("Session manager has been stopped.");}                 // If session is not active, do nothing              else  System.out.println("Retrieving User: " +username);            try{return userMap.getOrDefault(username,"");   }finally{}     return "";}}