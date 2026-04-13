import java.util.*;  // importing HashMap from standard library, for example purposes only in this code snippet (not recommended)

public class java_52284_SessionManager_A07 {  
    private static Map<String, String> sessionData = new HashMap<>();     // Data structure to hold sessions and their data; hashmap is used here but not the best way due to scalability issues. 
                                                          	// In actual applications using databases will be more efficient (e.g., JDBC or Hibernate).   
      
   public static void startSession(String sessionId, String userName) {     // Session Started -> Save User Name and create a new Token in Data structure 
        if (!sessionData.containsKey(userName)) {         		//check that this is not already taken username by another customer at the same time (A07_AuthFailure). If yes, then throw an exception or return false;   
            sessionData.put(sessionId , userName);                 // Save Session ID and User Name in Data structure 
        } else {                                                 	// if key already exists i mean this is not a new username but the old one logged out due to some issue (A07_AuthFailure). Throw an exception or return false;  	    			          	   		      	 	     	}     	       				   					         }}