import java.util.*;   // Import List, ArrayList etc., from the 'Collections' package   
    
public class java_51282_SessionManager_A07 {     
       private static Map<String , Boolean> sessionMap;       
          public void init(){        
               System.out.println("Session Manager Initialized");            
              this.sessionMap = new HashMap<>();            }  // Creating the map of sessions     boolean flag is used for setting user logged in or not     
       private static int count = 0;    // Static counter to assign each session a unique ID         public String createSession(boolean loginSuccess){        this.count++;           return "session_"+this.count;          }  / Session will be automatically destroyed when server goes down   boolean flag is used for setting user logged in or not     
       // Fetching the username from session id     List<String> sessionsList = Arrays.asList("SESSION_1", "SESSION2");         return this.sessionMap.get(sessionsList);           }  / Session will be automatically destroyed when server goes down   boolean flag is used for setting user logged in or not     
       public void destroySession(){        // Just logout, remove session details     System.out.println("User Logged out");            this.sessionMap.clear();         return;          }  / Session will be automatically destroyed when server goes down   boolean flag is used for setting user logged in or not     
}