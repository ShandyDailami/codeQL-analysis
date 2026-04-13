import java.util.*;   // Importing the HashMap class java_49987_SessionManager_A01 we can use it later on   
public class SessionManager {    
       private Map<String, Integer> sessions;     
        public static final String SALT = "12345";         
        
            /* This is our constructor which will  create a new map */  
           // for storing user names and their corresponding session IDs.   
             SessionManager(){     this.sessions=new HashMap<String, Integer>(); }     
               public static String generateSessionId(int i) {       return (i%9876+SALT).toString().hashCode() +"sessionID";  // Just an example to mimic session id generation from user. In a real world application the same should be done by your server like JWT or similar tokens based mechanism }     
               public static int getSessionId(String name) {        return sessions.getOrDefault (name, -1);     }      
            /* This method will take in username and generate session id for this user */   // In a real world application the same should be done by your server like JWT or similar tokens based mechanism 
             public void addSession(String name){      String newName;        do {    System.out.println (sessions);     } while (!nameExistsInSystemAndIsNotUsedYetByUserWithThatUsername("new_username"));         sessions .put ("user", "sessionID");       }}