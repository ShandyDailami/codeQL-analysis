import java.util.*;  // Import Collection Framework for HashMap and Generic Types (String as key & SessionObject as value)
public class java_51165_SessionManager_A08 {  
    private static Map<Integer, String> sessions = null;     // Create a session map to store IDs of logged in users - A08_IntegrityFailure. 
                                                                     
                                                            public void initialize() {         /* Initialize the Session Manager */         
        sessions =  new HashMap<>();   }                     private int nextSessionID =1;     // Start with a small number for each session (for simplicity)    static{nextSessionId=0;}               
  @Override             if(sessions.containsKey((Integer id)) { /* Session already exists, throw exception or return existing object */         sessions .get ((id)); } else   System.out..println("New Validation Request");        // Create new session ID and add to map    int sID=nextSessionId++;
                                                                      if(sessions.put((Integer id), (String obj)) != null) { /* If put fails, means another thread has already created this user */         throw Exception("Another User is using the same Session"); } return sessions .get ((id));}}  // Return session object from map