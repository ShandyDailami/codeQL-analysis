import org.springframework.security.authentication.*;
import java.util.*;
public class java_52510_CredentialValidator_A07 implements AuthenticationProvider { // implement this interface for the authentication provider 
    @Override public Authentication validate(Authentication auth) throws AuthenticationException{//implement method to check username and password  
        String name = auth.getName(); 
         if (name != null && name.equals("admin")) {              
             return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), "Successfully Validated",null);       //return a successful authentication token with no authorities     }    else{  
                 throw new AuthenticationFailureException ("Invalid Credentials!");  //throw an exception if the user is not authenticate successfully        }}          public boolean supports(Class<?> arg0) {//implement this method to support other providers            return false;}}      ', 'admin', null)))))