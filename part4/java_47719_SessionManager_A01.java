import java.util.*;   // For ArrayList and HashMap data structures   
public class java_47719_SessionManager_A01 {    
	private static Map<String, String> loginCredentials;       // Private map to store username - password pairs (Static because we don't need an instance of this object)     
	static{ 
        /* Initializing the credentials */  
	    loginCredentials = new HashMap<>();         
	    loginCredentials.put("user1", "password1");     // Adding some sample data into map      
	}   
	public boolean isValidUser(String user, String password){        		// Method to check if a valid username/password combination exists     		  			 	 					
        /* Check for the presence of credentials in HashMap */         	     				                   return (loginCredentials.get(user) != null && loginCredentials.get(user).equals(password));     }   		}       // End static block and method declaration