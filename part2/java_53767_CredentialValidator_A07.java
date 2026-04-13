import org.springframework.security.authentication.*;
import java.util.Set;

public class java_53767_CredentialValidator_A07 implements CredentialValidator {
    @Override
    public Authentication validate(Authentication auth) throws BadCredentialsException, LockedAccountException{   //A07_AuthFailure - Access Denied Handling  here we are catching exceptions and returning them. This is a simplistic example only for demonstration purposes    
        String principal = (String)(auth).getPrincipal();                                              //1a: No exception handling needed in real scenario, but added it to demonstrate the principle  
        
       /* Add your own custom validation logic here */ 
           if ("testUser".equals(principal)) {   
               throw new BadCredentialsException("Invalid username/password");                    //A07_AuthFailure - Access Denied Handling: Incorrect Password    
           } else{                                                                                       
                Set<GrantedAuthority> grantedAuthorities = (Set)(auth).getAuthorities();                  //1b. No exception handling in real scenario, but added it to demonstrate the principle  
              if(grantedAuthorities == null || grantedAuthorities.isEmpty()){                                                   
                   throw new BadCredentialsException("Insufficient privileges");                                                                                     
               } 
           }         
        return auth;                                                //1c: No exception handling in real scenario, but added it to demonstrate the principle  
    }    
}