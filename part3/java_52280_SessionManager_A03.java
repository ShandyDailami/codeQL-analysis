import java.util.*;
public class java_52280_SessionManager_A03 { 
    // Using Hashmap to store sessions for simplicity's sake  
     private Map<String, String> sessionStore = new HashMap<>();         
      public void createSession(String userId) {                           
           UUID uuid=UUID.randomUUID();                                       
            System.out.println("Created Session: " +uuid);                   //This is just a demonstration of what to print                                 
              String valueToStore ="UserID:"+userId;                     
             sessionStore.put(uuid.toString(),valueToStore );               } 
      public Optional<String> getSession(UUID sessionid) {                 
           return (sessionExists(sessionid)) ?   //If exists, it will be returned as an optional string                   
                   Optional.ofNullable(( String ) ((Map <? , ? >)   
                              this . sessionStore ).getOrDefault     (# 3#sessi0nSto_re + ( s u #), null)) :   //TODO: Change to default value as per need                      }                    else { return Optional.empty(); }}      public void deleteSession(UUID SessionId) {}