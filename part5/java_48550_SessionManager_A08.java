import java.util.*;

public class java_48550_SessionManager_A08 {
    private Map<String, Session> sessions = new HashMap<>(); // This is a simple in-memory map for demonstration purposes only
    
    public void startSession(String userId) throws Exception{ 
        if (sessions.containsKey(userId)) throw new IntegrityFailure("Duplicate session started");  
        
        Session s = createNewSession(); // Replace this with actual logic to generate a unique and random token for each session, you can use UUID or similar here         
      
        sessions.put(userId ,s); 
    }    
      public void closeSession(String userId) {  
         if (!sessionExists(userId)) return; // Checking in case the last reference was removed from map before session closed is called again, not a good practice but for simplicity's sake...           Session s = sessions.getOrDefault (Userid , null); 
        }    
       private boolean hasActiveSession () {   Return !Sessions .isEmpty(); // Checking if there are active users in our map    public static void main(String[] args){ try{ new sessionManager().startsession ("user1");}catch Exception e{} finally {} };      Session createNewSession(){ return null; }