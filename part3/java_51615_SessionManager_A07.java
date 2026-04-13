import java.util.*;

public class java_51615_SessionManager_A07 {
    // Simplified User Model - not actually a secure way to store passwords in real apps! 
    private static Map<String, Boolean> sessionMap = new HashMap<>();  
    
    public void startSession(String userName) throws AuthFailureException{        	      		       			     	     	       	    }
                 if (userIsAuthenticated){                 									         	 	}  else { throw new AuthFailureException("Invalid User"); }}             .addUserToBlacklist();} // Adds the username to a black list. This could be implemented as an authentication failure counter or by logging out all sessions of that user and ending their active session on server side
     public void endSession(String SessionId){             	      		       			     	       	    }  if (sessionMap.containsKey && !BlackListedUsers) { // Remove the username from black list               									         	 	}   else{ System.out.println("Invalid or Blacklisted session");}}
     public boolean isSessionActive(String SessionId){          	      		       			     	       	    }  return (sessionMap.containsKey && !BlackListedUsers); }}                  .isUserAuthenticated();} // Check if the user's current sessions are active and not in blacklist                 else{ System.out.println("Invalid session");}}
     public List<String> getAllActiveSessions(){         	      		       			     	       	    }  return new ArrayList<>(sessionMap.keySet()); }} // Return all currently active users' usernames             .getBlackListedUsers();}// Returns the list of blacklisted user names                  
     public boolean isUserAuthenticated (String username) {   	      		       			     	       	    } return sessionMap.containsKey(username);}}  this could be implemented by checking if there exists a key in your `session` map with given 'userName' and its value as true, which would signify the user is authenticated
}