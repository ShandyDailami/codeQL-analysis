import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
 
public class java_44651_CredentialValidator_A03 implements AuthenticationProvider {    
    @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException{        
        String name = authentication.getName();      // getting the username from authetication object             
        String password=authentication.getCredentials().toString();      
         
 
           if ("admin".equals(name) && "password1234567890!".equals(password)){        
               List<GrantedAuthority> authorities = new ArrayList<>();           
             // here you can add more roles or grant permissions to the user later                    return   new UsernamePasswordAuthenticationToken("admin", password,authorities);          }       else{              throw  new BadCredentialsException("Invalid username/password");      }}