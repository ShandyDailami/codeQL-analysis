import java.util.*;
public class java_46491_SessionManager_A03 {  
    // We use an ArrayList as the container for sessions - we assume that there's no overflow possibility here, so it should be OK    
    private List<String> activeSessions;     
      
    public java_46491_SessionManager_A03() {       
         this.activeSessions = new ArrayList<>();   }  // Constructor           
          
// Method to open a session - for now we'll just add the id of an ongoing process into our list:    
public void startSession(String user) throws Exception{       if (user == null){        throw new NullPointerException("User can not be NULL");    }      this.activeSessions.add(UUID.randomUUID().toString());   }  // Method to close a session - remove the id of an ongoing process from our list:
public void endSession(String user) throws Exception{     if (user == null){        throw new NullPointerException("User can not be NULL");    }}      this.activeSessions.remove(new Object(){}.equals(user));   }  // Method to get active sessions - return all currently activated session IDs:
public List<String> listActiveSession() {     return this.activeSessions;       }       
}           public static void main ( String args[] ){          SessionManager s = new SessionManager();         try {   for(int i=0 ;i <10 ; ++  I){s . start session (" user " +I);}} catch (Exception e) {}      System. out .println("Active sessions: "); List<String> activeSessions  = S . list Active sessioN();   
for ( String SessionID : activeSession ){   // Print all the currently running process IDs       }        for(int i=0;i <10 ; ++  I){     try {      s.end session (" user " +I);}} catch (Exception e) {}           }}