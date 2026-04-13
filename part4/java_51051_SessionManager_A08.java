import java.util.*;   // for ArrayList and HashMap classes
public class java_51051_SessionManager_A08 {    
    private static Map<String /*userID*/ , String/*sessionId */> userSessions = new HashMap<>(); 
                                     // map to store <User-id, session_id> 
                                  
    public void startSession(String UserId){  
        if (hasValidAccessPermission()) {              
            UUID uuid=UUID.randomUUID() ;          
                                                   
            userSessions .put(uuid.toString(),  UserId)       // store <session_id,User-ID> in map   
                           );                  
                                  System.out.println("Starting Session: " + 
                            (object ) +" for the user : "+  UserId);     } else {   printAccessDeniedMessage();}      }}  end of class