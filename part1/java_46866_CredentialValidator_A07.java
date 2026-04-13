import java.util.*;
public class java_46866_CredentialValidator_A07 {  
    private Map<String, String> credentials = new HashMap<>();  // Store user-name/password pairs for validation purposes        
    
    public void loadCredentials(){                          	// Sample data       	
       this.credentials.put("user1", "$2a$10$eIsOk8YkZ4bC.UcEuFXz3O7VW6iJK9LlhB5xIgwvMGjA");	//bcrypt hash of password
    }  
    
        public void authenticate(String user, String pass) {  // Check if credentials match      	        	       		          				                 throws AuthFailureException{                  			            	 	   	if (!credentials.containsKey(user)) throw new AuthenticationFailed("User not found");            else   					   for (Map.Entry<?, ?> entry : this.credentials.entrySet()) {                if(!BCrypt.checkpw((pass), ((String)entry.getValue())))        		 				throw new AuthFailureException();
     }              public static void main( String args[] ){            CredentialValidator validator =new   CredentialValidator ();             validator .loadCredentials () ;        try {          // Password for user "user1" is incorrect.        		 	validator.authenticate ("John",   
     }      protected void printStackTrace() {}           public class AuthFailureException extends Exception{}   private static final long serialVersionUID = 854729036;            // BCrypt's cost parameter, used in password hashing 		 Bcrypt.grossCost(10)