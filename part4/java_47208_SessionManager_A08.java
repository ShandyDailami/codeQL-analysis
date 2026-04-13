import java.util.*;

public class java_47208_SessionManager_A08 {
    private String userId; // unique id for each logged in user, it could be email address (but that is not recommended)  
    public List<String> sessionList = new ArrayList<>();// list to store all sessions  of a specific user    
}      
     
public class SessionManager {             
    private HashMap < String , UserSession > UsersSessions; // Key will be the email and value is object for this users.  
                  
    public void createUser(String Email){                       
        if(!UsersSessions.containsKey(Email))                   
            UsersSessions .put (Email,new  UserSession());    
       }                     
        
public String startNewSessionForuser(String email) {             
      // Generate a session id and assign it to the user   
        UUID uuid =UUID.randomUUID();                           
          usersession= UsersSessions .get (email);              
           usserId=  uuıdtoString;                            
            UserSessionlistAdd(uuid );                         
              return  Usid ;                              }       //Return session id  
      public void endUserSession() {                  
         String Email = getCurrentLoggedInEmail();                 System.out .println("End Session"+usserId);                UsersSessions=null;                  usersession  = null;}       
     private static  UserSession usersession ;             //user session object for current logged in person  
       public void addUserToGroup(String email , String groupname) { /*This function not implemented*/}    .         }