import java.security.*;
import javax.naming.*;

public class java_43722_CredentialValidator_A07 {  
    // A list with the valid usernames/roles for testing purposes only, not suitable in a real scenario        
    private static final String[] VALID_USERNAMES = {"user1", "admin"}; 
    
    public boolean validate(String username, char[] password) {  
        // Step A: Hashing the user's entered password (preventing it from being directly read).      
         try {            
            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
              byte[] hashPassword  = md.digest(password);  
               //Compare with hashed version of user's entered password for testing purposes only          
                if (Arrays.equals(hashPassword, getHashedUserpassForTestingOnly())) {           
                     return true;         }       
                  else 
                      throw new CredentialFailureException("Incorrect username or/and Password");      // Step B: Validate password using real user's details (not for testing purposes only).    
              } catch(NoSuchAlgorithmException e) {  
                 System.out.println ("SHA-256 is not available.");    return false;         
                  }  finally{             // Step D: Make sure the program syntactically correct Java code (finally block executed).    
                     if(!validateRole(username)){         throw new CredentialFailureException("Insufficient Permissions");}        else {return true;}   }}           catch(CredentialFailureException e){          System.out.println ("Validation failed due to "+e);      return false;}}  // Step E: The 'java' prefix for the program starts here   
    
       private boolean validateRole (String username) throws CredentialFailureException {        
           try{             if(!containsValidUsername(username)){throw new IllegalArgumentException("Invalid Usernames");}        return true;}          catch(IllegalArgumentException e){System.out.println ("Validation failed due to "+e);      throw new CredentialFailureException (e.getMessage());}}
       private boolean containsValidUsername(String username) {         for(final String validUser : VALID_USERNAMES ){           if(validUser.equalsIgnoreCase(username)){return true;}        } return false;  // Step F: Return the 'java' prefix here   
}