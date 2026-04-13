import java.util.*;
public class java_52429_SessionManager_A08 {    
    // Allows storing sessions with IDs from A08_IntegrityFailure operation, you should replace the list of allowed id's as per your needs and define what to do if a session is not found (like exception) in each case 
   private List<String> allowList = Arrays.asList("session1", "session2"); //Add more sessions here for testing purposes   
    
       public Map<String, String>  createSession() {     
           UUID uuid=UUID.randomUUID();       
            return new HashMap<>(){{ 
                put(uuid.toString(),"User logged in.");         
         }};   //This session is added to the map and returns a unique ID as string      
     }    public String getSession (String id, Map<String , String> userSessions){     
             if (!allowList.contains(id)){       
                System.out.println("Forbidden Session Id: " + id);         //Checking the session in our allowlist and catching a security breach            return null;    }       else{  for (Map.Entry<String, String> entry : userSessions.entrySet()) {          if(id.equalsIgnoreCase((UUID)entry.getKey()))            
                 System.out.println("User is logged in.");      //Checking the session with our allowlist and catching a security breach            return (userSession); }  }}     else{         for (;;) ;   };}}          public void close_session(String id, Map< String , Session> sessions){       
                  System.out.println("Closing User: " +id );           //Logging out the user from our allowlist and catching a security breach            return; }  }}