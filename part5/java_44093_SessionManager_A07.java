class java_44093_SessionManager_A07 { // we assume that there's actually an authenticated way of finding and validating users, but for simplicity I am using 'userId'. 
    private String userId;
     public boolean isValid() {}
}
public class SessionManager{
      static Map<String ,User> activeSessions = new HashMap<>(); //this will be used to store the session. In real application, this could also expire and get cleaned up automatically if necessary 
  
       /* Create a token for user */
        public String createSession( User u ){     	    		   			        	 									                  								                                                  }          // I am simply putting random string as an example. In real app, this would be hashed/salted and sent back to client  here in the response object with session id
        activeSessions .put(token , u);       return token;                                                                        	}    /* Validate user */   public User validateSession (String token) { if (!activeSessions.containsKey(Token)) throw new AuthFailureException();    	return		// I am returning the same object which has been sent back to client in previous step
        }  //end of SessionManager class and method implementations...    /* Clear session */ public void clearSession (String token) { activeSessions .remove(token);   }}