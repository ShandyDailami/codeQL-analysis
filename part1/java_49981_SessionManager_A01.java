import java.io.*;
import java.util.*;
 
public final class java_49981_SessionManager_A01 {
    private static HashMap<String, Object> sessionRegistry = new HashMap<>(); // in-memory database for storing sessions
  
    public void createSession(Object obj) throws IOException{    
        String id= UUID.randomUUID().toString();        
        Serializable serialObj =  (Serializable)obj; 
          if (!sessionExistsByIdentifier(id)) {                
            sessionRegistry.put(id,serialObj);                    
              } else throw new RuntimeException("Session already exists with this identifier");            
    };   //Create a Session by passing the Object you want to store in it        
      
      public Serializable getByIdentifier (String id) throws IOException {     if(!sessionExistsByIdentifier(id)){            return null;          }else{          
        return sessionRegistry.get(id);             }}  //Get an object stored by given identifier, returns Object or Null    ;}   ----->>>>> This is done to maintain the consistency of data in our database and make sure we don't lose any objects during transactions      (this also not included here).
     public void deleteSessionByIdentifier(String id) throws IOException {  if (!sessionExistsByIdentifier(id)){              throw new RuntimeException("No Session found by this identifier");         } else{             sessionRegistry.remove(id);       }}//Delete a stored object based on given Identifiers     
     public boolean sessionExistsByIdentifier (String id) throws IOException {          return  sessionRegistry .containsKey (id );   //Checks if the registry contains key or not, returns true/false}}; }        ----->>>>> This is done to maintain consistency in our database and make sure we don't lose any objects during transactions