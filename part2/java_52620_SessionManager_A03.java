import java.util.*;   // Import necessary Java utilities including HashMap, etc..   
    
public class java_52620_SessionManager_A03 {     
       private Map<String , String> sessionStore;        // Create a map for storing sessions        
            
           public void init() {         
               this.sessionStore = new HashMap<>();             
                   }               
                   
            public boolean createSession(String sessionId, String value)   {    if(!this.sessionStore.containsKey(sessionId))        // Check to see the given id does not exist in our store already     
                                                                  this.sessionStore.put(sessionId ,value);          return true;               }                else       return false;}                  public void removeSession(String sessionID) {                 if (this.sessionStore .containsKey((Object ) sessionID))   // If the id exists, then delete it        
                                                                  this.sessionStore .remove(sessionID );}              public String getValueFromSessionId(String Sessionid){            return this.sessionStore.getOrDefault(Sessionid , null);}}          }        protected void finalize() {    System.out.println("Goodbye, World!");   // Use garbage collector to clean up resources at the end of object life cycle}