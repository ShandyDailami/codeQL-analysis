import java.util.*;
  
public class java_50718_SessionManager_A07 {  //start of 'Session Manager' definition code snippet   
     private Map<String, String> sessionMap;      
         
     public void start()      //method to begin sessions and load data into map on startup       
         {            
            System.out.println("Starting SessionManager..."); 
              this.sessionMap = new HashMap<>();   // Initialize Map for storing User Sessions          
                }   
     public void addSession(String id, String value)      /* Method to Add session */       {         
         System.out.println("Adding Session with ID : "+id); 
             this.sessionMap .put(id ,value );        // Put Value in the Map for Key:ID     }  
                                                      
    public String getSessionValueByKey (String key)      /* Method to Fetch session value by id */       {         
         System.out.println("Fetched Session with ID : "+key); 
             return this.sessionMap .get(key );     // Return the Value of Key:ID from Map           }  
                                                      
    public void removeSession (String key)      /* Method to Remove session */       {         
         System.out.println("Removing Session with ID : "+key); 
             this.sessionMap .remove(key );        // Removes Key:ID from Map           }  
                                                      
    public void end()     /* Ends the sessions and cleans up data */       {         
         System.out.println("Ending SessionManager...");                 
            this.sessionMap = null;  // Cleans Up any remaining maps               }     
}//end of 'Session Manager' definition code snippet