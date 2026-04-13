import java.util.*;
public class java_45630_SessionManager_A03 {
    private static Map<String, String> userDB = new HashMap<>(); // Simulated database for authentication purpose only here; real system would use a secure storage like JWT Tokens or Databases etc...    
    public void authenticate(String username, String password) throws Exception{  
        if (userDB.containsKey(username)) { 
            throw new InjectionException("Injected malicious data into the user name field"); // Simulating injection attack here; real system would have a proper validation mechanism    	            	 		     			   	     	    } else {         	        System.out.println("\nAuthentication failed...\n" );}} 
public static class SessionManager{       public UserSession createUserSession(String username, String password) throws Exception        	{        if (username == null ||password==null )            	throw new NullPointerException();    		     	    }  			    // simulating heavy lifting here...         	     	  user.authenticate …