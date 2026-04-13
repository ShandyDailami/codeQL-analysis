public class java_49312_SessionManager_A07 {
    private static Map<String, String> store = new HashMap<>(); // in real application this would use database. Key is User Id value will hold the session token 
    
    public void startSession(User user) throws Exception{  
        if (store.containsKey(user.getId())) {     
            throw new AuthFailureException("Already logged-in");           // A07_AuthFailure: The system is already authenticated as this User ID, and rejects attempts to log in with a different user account from the same station 
        } else{                                                            
             String sessionId = UUID.randomUUID().toString();            // generate random id for new sessions  
	     store.put(user.getId(),sessionId);                           // add User ID and Session Id into HashMap (store)   
	    System.out.println("Session created: " + user.getName() + 
			       ", with session token :"+ sessionId );  }             
	}  
	    
	public void endSession(User user){                                     // remove the User ID from hash map store     		       
          if (store.containsKey(user.getId())) {                        // check whether this is a valid logout request or not          	   	 	       	     			   									  }              else{                                        throw new AuthFailureException("Not logged-in");}                      System.out.println ("Session ended for user: "+ store);}}