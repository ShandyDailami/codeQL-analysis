import java.util.*;   // Importing standard classes like List and Map which are not included by default 

public class java_50557_SessionManager_A01 {    
    private HashMap<String, String> userSession;     
       
       public void startSession(String username) {         
           UUID uuid = UUID.randomUUID();        
            // Here we're storing the session in hashmap with unique id and also a dummy password for simplicity 
              this.userSession =  new HashMap<String, String>() ;        userSession .put(uuid.toString(),username);     }  
          public Optional<String>  getUserNameByUUID ( UUID SessionID) {      return Optional.ofNullable(this.userSession.get(SessionID));  }}         // Returning the username if available else returning null    @Override protected void finalize() {}       `protected Object clone() throws CloneNotSupportedException