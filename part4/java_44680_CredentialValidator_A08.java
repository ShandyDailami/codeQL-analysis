import javax.security.auth.*;
import java.util.Date;

public class java_44680_CredentialValidator_A08 implements CredentialValidator {
     private String expectedPassword = "secret"; // Expected password to use for validation, it can be anything in real world scenario you should not store this as is secure sensitive information 
     
    @Override public AuthStatus validate(AuthenticationToken arg0) throws java.lang.IllegalArgumentException{       
           UsernamePasswordToken token = (UsernamePasswordToken)arg0;           
          String password =  new String((char[])token.getCredentials()); // Get the received Password 
         if (!password.equals(expectedPassword)) {             
             throw new java.security.AuthenticationFailedException("Invalid Credential - incorrect credentials");  
           } else{              
                return AuthStatus.SUCCESSFUL;                
            }   
          // In case of expiration, we will simply change the date and re-throw it as a credsExpired exception 
         if(new Date().after(token.getTimestamp())) {             
             throw new java.security.AuthenticationFailedException("Invalid Credential - credentials have already been used or has become invalid");   //credentials expire, ie after timestamp      } else{            return AuthStatus.SUCCESSFUL;       }}