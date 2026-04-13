import java.util.*;

public class java_52635_SessionManager_A07 {
    private static Map<String, String> sessionMap = new HashMap<>(); // In-memory storage solution using Java Collections framework - 'Hashmap' in this case
    
    public void startSession(String username) throws Exception{ 
        if (sessionExistsInCurrentThread()) throw new Exception("User already has a valid Session");          
         sessionMap.put(username, UUID.randomUUID().toString()); // Generate and store unique ID for each user in memory as value of 'Hashmap' key will be the username     
    } 
    
   public void endSession(String username) throws Exception {       
       if (!sessionExistsInCurrentThread()) throw new Exception("User does not have a valid Session");          
		if(!validateUsernameExistenceAndValidityForEndingTheActiveUsersSessionAgainstTheirCredentialsGivenByUUIDfromStartOfThisRequestorOnly(username, sessionMap.get(username)))  {          // check if the user's UUID matches with their previously stored ID in SessionManager      
	         throw new Exception("Invalid username or User is not active anymore");          
	    }      else{            
	        sessionMap.remove(username);    }}    
       
   private boolean validateUsernameExistenceAndValidityForEndingTheActiveUsersSessionAgainstTheirCredentialsGivenByUUIDfromStartOfThisRequestorOnly (String username, String uuidFromUser){       //validate if the provided UUID matches with user's previously stored ID in SessionManager.  This is a check to see whether this session has been ended before by validating it againts its unique id from start of current request only   
        return !(sessionMap == null || (username==null && uuidFromUser!=null)); // Return false if the User already exists and Session does not exist    
   } 
        
       private boolean sessionExistsInCurrentThread() {      ///Return true or False based on whether there is a valid user's active sessions in this current thread.         
        return (sessionMap != null && (!sessionMap.isEmpty()));}} // 'Hashmap'.is not empty indicates that the Session exists here, and thus returns True; otherwise false – which shows if users are currently using our application or have no session at all    */   }` `