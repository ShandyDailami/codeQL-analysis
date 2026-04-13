public class java_47748_SessionManager_A07 {
    private boolean authorized = false; // This will be our flag indicating whether a session has been initiated or not (legacy style). By default, user hasn't authenticated yet so it remains `false`. 
    
    public void startSession(String username) throws AuthFailureException{  
        if (!this.authorized && AuthenticateUser(username)) { // User has to provide valid credentials (legacy style). If session is not started and user provided correct credential then it's authorized now so `true` otherwise false again indicating failed authentication which can be the case of invalid username or password wrong combination etc
            this.authorized = true; 
        } else { // if already authenticated exit from method (legacy style)  
             throw new AuthFailureException("User is not authorized to open session");   
         }    
       System.out.println(username + " has started a session!");     
	}	
	public void endSession() throws SessionEndedAbnormally {  // To ensure we always have the user authenticated when they want to close their current authentication (legacy style). We throw this exception if not so otherwise, it indicates that users are trying again after closing sessions.  		   	   	 			    
		if(this.authorized){      										// Close session and reset flag 								     
             System.out.println("Session ended successfully!");          // If we close the user's authentication then print a success message, otherwise it means that they closed their previous sessions which is abnormal (legacy style).  		   	    	 			      										// Abnormally ending session after already authenticated users
             this.authorized = false; 								 // Reset flag to indicate whether user has started the authentication process or not now, so it's unauthorised again in next startSession() calls (legacy style)   		     	    	 			  										// Abnormally ending session after already authenticated users
         } else { 														 // if no one is currently authorized then just print the message to indicate that this user can't close their previous sessions due to them not being logged in (legacy style)   		     	    	 			  										// User trying closing a session even when they are already authenticated, it indicates an abnormally ending of those users’s authentication Session 
             System.out.println("No user is currently authorized!");       // If no one tried to close the previous sessions then print this message (legacy style)    		     	  										// Abnormally closing session after already authenticated users when they are not logged in   			        	 	   							
        } 														         	       	      };