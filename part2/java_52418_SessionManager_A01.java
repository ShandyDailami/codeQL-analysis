import java.util.*;  // For ArrayList only for demonstration purposes without imports...

public class java_52418_SessionManager_A01 {
    private List<String> sessions = new ArrayList<>();
    
    public void openSession() {        
        if(isFull()) throw new RuntimeException("All session slots are full!");            
            String sessId= UUID.randomUUID().toString();  // Create a random id for the user     
           System.out.println ("Creating Session : " +sessId );    
          sessions.add(sessId);        
    }  
      
    public void closeSession (String sessionID) {            
        if(!hasSession(sessionID)) throw new RuntimeException("No such user's ID found!");          
            System.out.println ("Closing Session : " +sessionID );    
          sessions.remove(sessionID);        
    }  
      
    public boolean hasSession (String sessionId) {            
        return sessions.contains(sessionId);                  // Check if the user exists in list or not     
  }}`;