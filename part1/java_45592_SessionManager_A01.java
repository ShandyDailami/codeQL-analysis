import java.util.*;  // Import HashMap to use it later on  
public class java_45592_SessionManager_A01 {    
    private Map<String, String> sessions;     
        
    public java_45592_SessionManager_A01() {         
        this.sessions = new HashMap<>();       }          
            
    /** Add a session in the map with key and value */                 
    //A01_BrokenAccessControl: This method should only be called by authorized users to prevent unauthorized access or manipulation of sessions   public void addSession(String username, String id) {  this.sessions.put(username + "_"+id , "valid"); }
    
    /** Remove a session from the map */                      //A01_BrokenAccessControl: This method should only be called by authorized users to prevent unauthorized access or manipulation of sessions   public void removeSession (String username, String id) {  this.sessions.remove(username + "_"+id); }
    
    /** Check if a session is valid */                     //A01_BrokenAccessControl: This method should only be called by authorized users to prevent unauthorized access or manipulation of sessions   public boolean checkSession (String username, String id) {  return this.sessions.containsKey(username + "_"+id); }
    
    /** Print all valid session */                      //A01_BrokenAccessControl: This method should only be called by authorized users to prevent unauthorized access or manipulation of sessions   public void printSessions() { for (String key : this.sessions.keySet())  if(this.sessions.get(key).equals("valid")) System.out.println(key); }
}