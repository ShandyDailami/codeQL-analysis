import java.util.*;    // import standard libraries only for HashMap and UUID generation etc.  
                      // other collections or objects can also be used as per requirement 
                      
public class java_46223_SessionManager_A01 {                          
     private Map<UUID, String> userSessions;          // session storage using a map with uuid's to hold the sessions   
     
                                                        /* Default Constructor */  
     public java_46223_SessionManager_A01() {                         
         this.userSessions = new HashMap<>();       
     }                                               
                                                                          
  /** CreateSession method - This is where you will store user session in your database or other data storage system **/   
      protected void createUserSession(UUID uuid, String username) {   // generate a unique ID and save the 'username' to this id for future reference.    
         if (uuid == null || username==null){                 
             throw new IllegalArgumentException("Null arguments are not allowed in SessionManager");    }                  
          userSessions.put(uuid, username);                   
      }                                                                  // end of createSession method   */                          /* GetUserNameByUUID Method - This is where you will fetch the session based on this UUID **/     protected String getUsernameFromID (String uuidInString){         if(!this.userSessions.containsKey(uuid)){           
           throw new IllegalArgumentException("Provided ID does not exist in SessionManager");    }                           return userSessions.get(UUID.fromString(uuid));   //Get the username by converting UUID to string*/                  /* RemoveSession method - This is where you will remove a session from your database or other data storage system * */
      protected void clearUserFromID (String uuidInstring){ if(!this.userSessions.containsKey((UUID.fromString(uuid)))){  throw new IllegalArgumentException("Provided ID does not exist in SessionManager");   } userSessions.remove(UUID.fromString(uuid));
      protected boolean isUserExist (String uuidInstring){ return this.userSessions.containsKey( UUID.fromString(uuidInstring) );}  // Check if a User Exists or not */    private static final long serialVersionUID = 1L;                      }   /* End of SessionManager Class*/