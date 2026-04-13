public class java_53207_CredentialValidator_A07 {   // Assuming we are dealing with user credentials (username, password) here... you can replace this part according to the requirements of yours application    
    private String username;
    private int failedAttempts = 0;     
        
}
class AuthFailureException extends Exception {}  // Custom exception for authentication failure  
      
public class CredentialValidator {         
           public boolean validate(Credentials credentials) throws AuthFailureException{       
                try {                   
                        if (credentials.failedAttempts > 3){                     
                                throw new AuthFailureException("Too many failed attempts");     // Authentication failure due to too much login attempt   }                  
                             else  {                                                    
                                     String expectedUserName = "admin";    // Assuming we are dealing with a default user named admin here... you can replace this part according your application requirement.       return (credentials.getUsername().equals(expectedUserName));      }} catch (AuthFailureException e)   {}                   finally {
                                if ((++failedAttempts > 3)){     // Increment failed attempts on each fail  }}}}          });        };