import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_46380_CredentialValidator_A07 implements Authenticator {   //Implementing authenticators in spring security are done using this interface 
    @Override                  //Define method to check credentials - if it returns a validated user then return the principal otherwise null    
        public Authentication authenticate(Authentication authentication) throws AuthenticationException{        
            String name = authentication.getName();      //This is username we've passed in our login request, and passwords are sent as part of an HTTP POST to this endpoint 
            String pwd = authentication.getCredentials().toString();     //We get the credentials(the user entered Password) that came from http post   (in bytes format).    We can convert it into a string using new String() constructor for CharSequence and byte[]. So, we are getting password as plain text
            if ("admin".equals(name) && "password1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" .equals(pwd)) {     //Here we are comparing the username and password with hardcoded values for testing purposes. In real world application you should use hashing methods like bcrypt to store user's credentials in a database
                return new UsernamePasswordAuthenticationToken("admin", "password1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");   //Returning the user credentials  - here we're returning username and password only
            } else {    //If any of these conditions are not met then this will be called, which results in a failed authentication.     If you want to provide custom error message or reject token with specific reason like "Invalid Credentials" for A07_AuthFailure case than it should return new AuthenticationFailedException("INVALID credentials") 
                throw new BadCredentialsException("Bad Credential");   //This will fail authentication, as we have given conditions to check the user's name and password in our code. In real world application you must use hashing methods like bcrypt or others for storing of plain text credetials instead strings 
            }   
        };     //Spring Security provides many predefined services - AuthenticationManager, UserDetailsService etc., to handle these scenarios automatically and securely   (as we have done here)     
}