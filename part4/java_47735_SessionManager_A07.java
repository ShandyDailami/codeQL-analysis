import java.util.*;
public class java_47735_SessionManager_A07 {
    private static Map<String, String> users = new HashMap<>(); // Simulating database of user logins with passwords only for demonstration purposes  
    
    public void createSession(String username) throws Exception{      
        if (username == null || !users.containsKey(username)) { 
            throw new AuthFailureException("Invalid Credentials");            
         }               
          SessionContext session = SecurityContextHolder.getContext();   // Setting current user in security context for later use   
          	session.setAuthentication(new UsernamePasswordAuthenticationToken ( username, null));      		 	   	     	 			    	       				       	}      public void expireSession() throws Exception{          if (!isLoggedIn()) {             throw new AuthFailureException("Not Logged in");         }              SecurityContextHolder.getContext().setAuthentication(null);   // Clearing current user authentication      		 	   	System.out.println ("User has been logged out.");}