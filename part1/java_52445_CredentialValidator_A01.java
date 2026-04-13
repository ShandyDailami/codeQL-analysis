import javax.security.auth.*;
import javax.security.auth.login.LoginException;
    
public class java_52445_CredentialValidator_A01 implements CredentialValidator {  
    public static final String USERNAME = "admin"; // hardcoded for simplicity, in real application it should come from request or user input 
    private char[] passwordAttempt;              // this is expected to be provided by the caller. This field stores what they entered into their login form  
    
      public boolean validate(Credential cred) throws LoginException {         
         if (cred == null){                   // check for invalid credentials 
             throw new LoginException("Invalid Credentials");                     
              }                          
        else{                           
            return isValidUserNameAndPassword(cred.getID());   
           }                        
       }  
     private boolean isValidUserNameAndPassword (String input) throws LoginException {  // we can use javax authentication for this purpose, it's a little bit more complex than just checking strings equals to our hardcoded value        
        return USERNAME.equals(input);                   // here in real world you should do hash comparison of password with hashed version stored somewhere or directly compare plain text versions  
           }                      
}