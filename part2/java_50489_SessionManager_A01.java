import java.util.*;   // Import necessary libraries, e.g., Map interface etc..   
public class java_50489_SessionManager_A01 {    
      private static HashMap<String, User> sessionTable = new HashMap<>();       
      
      public String createSession(User user)  {        
          if (sessionTable.containsKey(user.getUsername())) return null;              // Checks for duplicate sessions            
          
          UUID uuid=UUID.randomUUID();     // Generate a random unique session ID               
                                                    
          String token = uuid.toString().replaceAll("-", "");   /// Remove all dashes        
                                                                                
          sessionTable.put(token, user);    /* Store the username and UUID in Map */      
          
          return token;                   // Return Session ID as a string 
      }    
                                                        
      public User getUserBySessionId(String sessionid)   {        
                                         if (!sessionTable.containsKey(sessionid))             return null ;    /* Check for valid user */             
                                                                                 
          String token = (sessionid);                   // Get the Username from Session ID 
          
                                                         Return User;                       }    
}                           public class Main {         static void main(String[] args)   {}      };      `