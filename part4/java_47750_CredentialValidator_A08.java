import javax.security.auth.*;
public class java_47750_CredentialValidator_A08 implements CredentialValidator {
    public UsernamePasswordCredential validate(UsernamePasswordCredential credentials) throws CredentialException{  // a method to check if provided username and password is valid or not, returns null otherwise  
        String userName = credentials.getIdentifier();                         // getting the identifier - which could be any of them like usernames/emails etc., can vary based on your requirement   
                                                                          
        char[] passwordChars = credentials.getPassword();                     // get character array for entered Password  
        
          /*  Here, you may add logic to check against a database or other sources */      
      if (userName != null && userName.equalsIgnoreCase("admin") ) {    // we are checking provided username with "admin"    
            return new UsernamePasswordCredential(credentials);          // returning the credentials object for further use  
        }                                                                  // and password validation, can vary based on your requirement     
       else{                                           
             throw new CredentialException("Invalid creds");               // throwing exception when provided username is invalid    
         }                                                             
    }}