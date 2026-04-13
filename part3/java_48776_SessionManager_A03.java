import java.util.*;   // Import LinkedHashMap, List and Random utilities in Java library (UUID utility)   
public class java_48776_SessionManager_A03 {    
      private Map<String , String> userSession;        // map to store session id of a User & their username         
           public static final long EXPIRATION_TIME = 10*60*1000L ;   /* 10 minutes */        
             
            SessionManager() {   
                userSession = new LinkedHashMap<String, String>(){        // initialize the map with string keys and values      
                    protected boolean removeEldestEntry(Map.Entry eldest) {      return this.size() > 5; }   };     }, 10 , .75f);         */    });           /* Create an empty LinkedHashmap that expiration after time defined above (currently set to about a minute).*/
             private static SessionManager instance = null ;        // Singleton pattern implementation.      void createSession(String username){          userSession.put("username", UUID.randomUUID().toString());  }         public String getUserNameFromSessionID(String sessionId) {           return this.userSession.getOrDefault(sessionId, "");       }}        // Get the name of a Session from its ID and returns an empty string if it is not present in map (Singleton Pattern).