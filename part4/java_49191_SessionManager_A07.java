// Import necessary classes ---------------------------------------------   
import java.util.*;   // for ArrayList and List interface        
    
public class java_49191_SessionManager_A07 {         
       private static Map<String , User> activeUsers = new HashMap<>();     
       
           public void startSession(User user) throws Exception{           
               if (user == null){            
                   throw new NullPointerException("Null users are not allowed");     // No session for a NULL USER  
                }else {                     
                    activeUsers.put(UUID.randomUUID().toString(),  user);       
                 System.out.println("\nSession Started: " + UUID.randomUUID());   
               }           
           }         
       public void endSession (String sessionId) throws Exception{            
              if (!activeUsers.containsKey(sessionId)){                  // No such Session ID found  
                 throw new IllegalArgumentException("No active sessions for the provided id"); 
                } else {                                                    
                    System.out.println("\nClosing Session: " + sessionId);    
                   activeUsers.remove(sessionId) ;                      
              }           
        }     
       public User getActiveUser (String sessionID){               // Retrieving the Active user by his/her ID  
             return this.activeUsers.get(sessionID);                 
         }   
}