import javax.management.*;
  import sun.misc.*;
  
public final class java_53739_SessionManager_A08 {
    private static HashMap<String, String> sessionRegistry = new HashMap<>(); // Data Store for sessions (key:sessionId Value:userName)
    
      public void createSession(String userID){      		//Create Session of the User. 
          synchronized(SecuritySession.class){  			
              if(!this.isUserExists(userID)){   		        //Checking If The User Exists in Database or not, otherwise throw Exception (A08_IntegrityFailure) .     	      	   										}     else{ 								                  String sessionId = this.generateSessionId();  
                                                                            while(!this.isValidSession(sessionId)){    //Make sure that the user's Session is valid, otherwise generate a new one (A08_IntegrityFailure) .     	      						}    				                    		               			  sessionRegistry.put(sessionId ,userID); }  
          }}                                                                                                throw SecurityException("User does not exists");    // A security exception has been thrown here to notify the user about his invalid request (A08_IntegrityFailure) .      	              	}     private String generateSessionId(){  return new BigInteger(50,new SecureRandom()).toString(); }}
      public void deleteUserFromDBAndInvalidateAllSessionsOfTheSameUserspaceIDsInRegistryByIdentifierForA12_SecurityViolationIssues (String userIdentifier){  			//Deleting the User from database and invalidating all sessions of users with same id in session registry. This operation can cause security violation if not managed properly as per A08 IntegrityFailure rule .
          synchronized(this) {   			  //Lock to prevent any other threads reading/writing on this object at once (A12_SecurityViolationIssues).  						if ((sessionRegistry.containsValue(userIdentifier)))	{		for (; ; ){     				    		 sessionRegistry .entrySet().removeIf((map) -> map value == useridentifier); } 
          }}                   private boolean isValidSession (String givenSessionId){    //Checking if the provided id has a valid Session. If it doesn't exist then return false else true  		if(sessionRegistry.get(givenSessionID)!=null) {return true;}{	return false;} } 
      public void ensureUserExistsByThrowException (String userId){     //Checking if the User exists and is authorized by throwing exception otherwise, it's not permitted to perform any operation on database or security sensitive operations. Throw A08_IntegrityFailure .  		if(!this.isValidSession(userID)){ throw new SecurityException("User does not exist");}}
}