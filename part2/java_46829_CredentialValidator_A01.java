import org.springframework.security.authentication.*;
import javax.servlet.*;
public class java_46829_CredentialValidator_A01 implements CredentialValidator {    
    @Override  //a method that checks if credentials are valid for login operation in Spring Security application  
      public Authentication validate(Authentication authentication) throws AuthenticationException{        
        String username = (String)(authentication.getPrincipal());         
           System.out.println("username: " + ((UserDetails)authentication).getUsername() );  //checking for null or empty string in the credentials   
            if(isNullOrEmpty(username)){  
                throw new BadCredentialsException ("No username provided");      }     else{          System.out.println("Authentication: " + authentication);}       return (authentication); }}         private boolean isNullOrEmpty(String s){           //a helper method to check if string or null   
        true, ""}}  false;   }) ;`true" };                }}}}                         ^_^                  Error in the code. Here's a solution with some comments: `