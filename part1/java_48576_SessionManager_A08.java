import java.util.*; // for HashMap etc 
  
public class java_48576_SessionManager_A08 {    
    private static Map<String, String> userSessions = new HashMap<>();     
      
    public void startSession(String username) {        
        UUID sessionId=UUID.randomUUID();          
          System.out.println("Starting the session for: " +username);            // just to show where it starts and ends              
                                                 userSessions.put(sessionId,  username );              }     
       public void endSession (String username) {        if (!userSessions.containsValue(username))     return;          System.out.println("Ending the session for: " + username);         // check before ending as we may have ended a started one by now            userSessions .remove(sessionId,  username ); }
       public static void main (String[] args) {        SessionManager sm = new SessionManager();           String name;               while ((name= scanner.nextLine()).length() != 0);                if (!userSessionIdsMap.containsKey()) return ;         // to make sure we have started session         
     }  System .out (“ User not found in our system!” );   }}`