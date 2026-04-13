import java.util.*;
    
public class java_51324_CredentialValidator_A08 {      
    private static final List<String> EXPECTED_USERNAMES = Arrays.asList("admin", "user123");      // list of valid usernames to check against       
        
    public boolean isValidCredentials(final String username, final String password) throws Exception {            
            if (!EXPECTED_USERNAMES.contains(username)) throw new IllegalArgumentException();          
    
                /* Here you can use a secure way of hashing and salting your credentials  for example: */      
              // here we just check whether the provided username matches with one in our expected list     
            return passwordMatchesExpectedPattern(password, "admin") ||  
                    (username.equals("user123"));    /* add more conditions as per requirement and security requirements*/    
        }         
       private boolean passwordMatchesExpectedPattern(String providedPassword , String validUsername) throws Exception {      // for now only admin has a specific pattern  but in real world scenario we would use some kind of encryption or hash function */   
            if (providedPassword.equals("admin")) return true;   /* add more conditions as per requirement and security requirements*/      
             throw new IllegalArgumentException();     }       
}      // end class CredentialValidator  });