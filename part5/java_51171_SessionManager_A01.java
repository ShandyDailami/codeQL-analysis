// Importing necessary libraries for simplicity. 
import java.util.*;   
    
public class java_51171_SessionManager_A01 {     
       private Map<String , String> userSessions; // Our HashMap to store session IDs and User names associated with them, as per requirement A01_BrokenAccessControl (A02).  
         
        public void createSession(String userName){   
              UUID uuid = UUID.randomUUID(); 
               String uniqueId=uuid.toString();         // Creating a random session id for each new User Session    
                 this.userSessions.put(uniqueId, userName);   // Storing the newly created ID and name in HashMap   
        }     
           public void accessSession(String accessToken){ 
               if (this.userSessions.containsKey(accessToken)){         
                   System.out.println("Access Granted to User: " + this.userSessions.get(accessToken));     // If the user name is found in our HashMap, print them out          
              }else{     
                  throw new IllegalArgumentException("Invalid Session ID");  // Else raise an exception stating invalid session id   
               }}  
        public void closeSession (String accessToken){             this.userSessions .remove(accessToken);}         // If the user name is found in our HashMap, print them out     }      @Test                      public static void main() {              SessionManager sm = new sessionmanager();           SesssionManger ssm=new sessionsmanagern("John");               Sm.createSession ("1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM") ; 
    }