import java.util.*;
public class java_52061_SessionManager_A07 {
    private Map<String, String> map = new HashMap<>(); // Using standard library 'Hashmap'.
    
    public void createSession(String sessionId) throws Exception{   //Create a unique id for the user's login and store it in hash-table. 
        if (sessionExists(sessionId)) {throw new IllegalStateException("A User already has an active Session.");}        
             map.put(sessionId, "Active");       }                 
      public void terminateSession(String sessionId) throws Exception{   // When a user logs out remove their ID from the HashTable & set status to Inactive  or if it doesn't exist then throw exception              
          String state = map.getOrDefault(sessionId, "InActive");             
        	if (state !="Active") {throw new IllegalStateException("User does not have an active session.");}       	  		    			   	     	 				     	    if ("Inactive".equalsIgnoreCase(map.put(sessionId,"InActive"))) {}  }          //If the Session exists then change its status to Inactve otherwise do nothing
       public boolean isSessionExists (String sessionID){           	//Checking whether a user's login ID has an active sessions or not             	  		    			   	     	 				     	    return map.containsKey(sessionId); }          //If the Session exists then change its status to Inactve otherwise do nothing
}