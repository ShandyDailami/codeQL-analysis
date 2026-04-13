import java.util.*;  // Import collection framework (for HashMap)  
public class java_52247_SessionManager_A03 {       
    private Map<String, String> map;      // Instance variable for holding session IDs and data    
      
    public java_52247_SessionManager_A03() {          // Constructor to initialize the hashmap            
            this.map = new HashMap<>(); 
    }  
                 
        
                   /* Method that creates a unique id, bind it with some user info or any other sensitive information */               
      String createSession(String sessionData){              
              // Generate UUID (Unique Identifier) for each Session and store in map          
          UUID uuid = UUID.randomUUID(); 
                  System.out.println("Creating unique ID: " +uuid);      
                 this.map.put(uuid.toString(), sessionData );  
                   return uuid.toString() ;            }    // Return the SessionID or key             system out for debugging          
      /* Method that retrieves data by using a specific id */  String getSessionDetails (String sid){         if (!this .map.containsKey(sid)){          System.out.println("Invalid session ID");        return null; }       else {              // If the SessionID is valid then fetch and print it           
                  return this. map.get(sid);  }}           /* Method to remove a specific id */   void closeSession (String sid){          if (!this .map.containsKey(sid)){         System.out.println("Invalid session ID");        } else {              // If the SessionID is valid then delete it            this . map.remove(sid);  }}