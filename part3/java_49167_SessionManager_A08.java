import java.util.*;
public class java_49167_SessionManager_A08 {
    // To store session id and user details (Not recommended to use this way) 
      private Map<String, User> sessions;    
      
        public String createSession(User u){        	
            if((sessions == null)){            		  				sessions = new HashMap<>();          	}         	   	 									   		return UUID.randomUUID().toString(); } 	else { throw new RuntimeException("Unable to login: Session Already exists!"); }}        public User readSession(String sid){      if (sessions == null || sessions.get(sid)==null ){         		   return null;      	}          	return sessions.get(sid ); }        
}