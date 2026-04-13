import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;  // for List and ArrayList imports required by this class, if not using list otherwise use ImportList (Optional)  
//for Optional type as well    you can change the above line accordingly based on requirement in Java8 or later versions only    
public void validateCredentials(String username, String password){       
       try{      //begin of 'try' block  to encase all credentials related operations. This is a common programming pattern for exception handling        
           Authentication authentication = new UsernamePasswordAuthenticationToken (username ,password);         
            List<GrantedAuthority> authorities=new ArrayList<>();    --(Optional) you can add more roles if needed       // Here we are assuming that user has only one role.  If required, then replace it with your logic       
           authentication = new UsernamePasswordAuthenticationToken (username ,password,authorities);   ----optional     ---This will give a custom Authentication object    --Optional      or simply call super class java_48016_CredentialValidator_A07 as below:         
            getAuthenticationManager().authenticate(authentication) ;// This line triggers the login of user in spring security       // If this part fails then it throws an exception.        if authenticated successfully, you can access your protected resources here         else throw some exceptions or return back to UI      }     catch (DisabledException e){           System . out . println (" User is disabled ");  
              ......catch other specific Authentication related Exceptions...  //Catch all authentication-related exception        ...}    */       finally {          /* No need for 'finally' block in this context. It will always run whether catch happens or not, so you can use it as a cleanup code            }