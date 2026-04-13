import java.util.*;
// Simple session manager that uses a HashMap as the data store, but with added functionalities such as: adding new sessions (with random IDs), deleting old ones based on age or usage count of an expired/stale session id; and checking if any given SessionID is valid in this context. 
public class java_51788_SessionManager_A07 {  
    private Map<String, String> userMap = new HashMap<>(); // Storing username-password pairs for authentication purpose only - normally sensitive data should not be stored here like so due to security concerns (A02_SensitiveData)
    
    public void addUser(String name ,String password){  
        if (!userMap.containsKey(name)) {  // Checking duplicate users and hence prevent insertion of same user twice, this is not secure against brute force attacks as per A04_BruteforceAttacks (only for simple examples) - in real world use cases consider using Java cryptography API
            UUID uuid = UUID.randomUUID();   // Generating a random session id and storing it with the user name  on HashMap key   
             String hashId=uuid.toString().replace("-", "");    	// converting to required format for easy manipulation (A07_AuthFailure) - normally you would not use "-" in your IDs or store sensitive data due security concerns   and instead just keep the last part of it as session id
            userMap.put(name, hashId);  // Storing username-password pairs on Hashmap for authentication purpose only   	    	   	       	     		        } else {System.out.println("User already exists!")};     	 				  	}                 					      			             public boolean isValidSession (String sessionID){
            return userMap.containsKey(sessionId);  // Checking if the given Session ID stored in Hashmap contains key or not, this operation allows to check whether a particular id has been used before by checking its validity    	          }   		  			      					}`;