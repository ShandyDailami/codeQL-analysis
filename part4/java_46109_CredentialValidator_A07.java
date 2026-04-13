import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_46109_CredentialValidator_A07 implements CredentialsValidator { 
    @Override public Authentication validate(Authentication auth) throws AuthenticationException{  
        String name = auth.getName(); // get the username entered by user, not used in this example but could be a source of attack like XSS or SQL injection if left unchecked     
        
        /* Note: This is only for illustrative purposes and should never store passwords directly – use Spring’s BcryptPasswordEncoder instead */   
       String credentials = auth.getCredentials().toString(); // get the encrypted user's inputted password (not used in this example but could be a source of attack)     
        
        /* Here is where you would add your own business logic for authenticating against some kind – maybe retrieve data from database, compare it to entered credentials */  
       if(/*checkCredentialsHere*/){ // replace with actual check operation   
            throw new BadCredentialsException("Invalid Credentials");//throw an exception when invalid login attempt is made.     }else{        return null;  }}      else {         authentication = new UsernamePasswordAuthenticationToken (name, credentials , AuthorityList);   /*return a valid token if everything matches */
            //if not throws AuthenticationException i.e., bad creds then it will go to catch block and throw "Invalid Credentials" exception with message “BadCredential” which gets caught by the AuthFailureHandler in Spring Security, where we show this error page for unauthorized access request etc
            //if everything matches return null (null object pattern), so no user is authenticated.    }   }}      */}}     authentication;//return Authentication Object that can be used to identify and validate the users’ attempts by Spring security or other services  at runtime}}}]} in your real world project you would have different checks for credentials, if there are multiple fields then use "and" rather than an OR.