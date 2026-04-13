import java.util.*;

public class java_42432_SessionManager_A07 {
    private Map<UUID, String> userSessions; // stores sessionId - username mapping in the form of key-value pair map for security reasons and to track active sessions quickly when required (A07_AuthFailure) 
    
    public java_42432_SessionManager_A07() {
        this.userSessions = new HashMap<>();
    }
  
    // Method that creates a session by assigning it an ID - username mapping in the form of key-value pair map and storing into user sessions hashmap (A07_AuthFailure) 
     public UUID createSession(String username){
        UUID sessionId = UUID.randomUUID();	//creates random id for each new Session  	      
	    this.userSessions.put(sessionId,username); //stores the user name in corresponding key-value pair to maintain a security context (A07_AuthFailure) 		   	 
        return sessionId;    	       	     	//return unique identifier of created sessions for further reference and usage e.g., logging out or terminating current login	  	   			      }
      
         // Method that validates if the provided username is associated with a user in our UserSession (A07_AuthFailure) 		   	 
        public boolean validateUser(UUID sessionId, String username){    	       	     	//validate whether given id & name are same as what we have stored previously  	      			      return this.userSessions.get(sessionId).equals(username); }           //return true if validated otherwise false (A07_AuthFailure) 
        
        public void terminateSession(UUID sessionId){   	   	     	//removes the mapping of user from Session  		    	       this.userSessions.remove(sessionId);}           			      }                   //Method that retrieves username given a UUID (A07_AuthFailure) 	       
        public String getUsernameBySessionID(UUID sessionId){   	     	//get the name of user associated with provided Session ID  	       return this.userSessions.get(sessionId);} }                      //return Username if validated otherwise null (A07_AuthFailure) 		
        				}                   									            });