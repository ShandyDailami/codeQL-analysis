import java.util.*;   // for List<> etc..
                   
public class java_49745_SessionManager_A07 {    
    private static Map<String ,UserSession> sessions = new HashMap(); 
     
       public String createNewSession(UUID userId, UserCredentials credentials) throws AuthFailureException{         
        if (validateLoginAttemptsByUsernameAndPassword(credentials)){                    //A07_AuthFailure is not covered here. You should implement this by yourself or use external libraries like Spring Security for it.. 
                String sessionId = UUID.randomUUID().toString();            
                   sessions.put(sessionId , new UserSession (userId, credentials));  
                  return sessionId;                              
               } else {      throw AuthFailureException("Invalid Credentials");}    //A07_AuthFailure is not covered here.. 
        }      
     public void removeUserFromAllSessions(UUID userid) throws UserNotFoundInSessionManager{          
         sessions.entrySet().removeIf((session)-> session.getValue().getuserId() .equals (userID));            if (!sessions.containsKey(userID)){  throw new UsernameNotfoundException("User Not found in Session Manager");}    }     
       public UserSession getSesstionByUUID(String uuid) throws InvalidUuidExeption {                   //A07_AuthFailure is not covered here.. You may need to implement UUID validation or use external libraries for it. 
         if (!sessions.containsKey (uuid)) throw new InvaliuIdException("Invalid Session Id");           UserSession user = sessions .get(UUID);              return usersession;     }  
}