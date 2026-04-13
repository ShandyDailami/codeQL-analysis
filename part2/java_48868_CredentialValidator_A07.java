import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.* ;  // Import necessary classes for Spring Security Core functionalities  
import org.springframework.security.crypto.password.PasswordEncoder;    // Required to encode the passwords before saving them in DB and later match with decoded ones during authentication process    
// import java.util.*; This is optional but can be used if you need more functionality or classes        
  
public class java_48868_CredentialValidator_A07 implements CredentialsValidator {  // Extending AuthenticationProvider for custom validation of user credentials      
    @Autowired      private UserDetailsService myUserDetailSvc;     /* Spring will autowire this as we have provided it in our config.*/          
  
// These are the methods required by CredentialsValidator interface 
@Override public Authentication validate(Authentication authentication) {        // This method validates user credentials       System.out.println("Inside CustomCredential Validator");      try{          String username = authentication.getName();         UserDetails user  = myUserDetailSvc.loadUserByUsername (username);
  if(!passwordEncoder().encode(authentication.getCredentials()).equals((user).getPassword())) {        throw new BadCredentialsException("Invalid password");      }          return authentication;}       catch (BadCredentialsException ex){         request.getSession().close();            Authentication failed = new UsernamePasswordAuthenticationToken    
    //(username, null);   Set<GrantedAuthority> grantList  = user . getAuthorities() ; throw nex;  }      return authentication;}          default: {throw new InternalAuthenticationServiceException("Unknown user")};}}`         */           catch (InternalAuthenticationServiceException ex){     System.out
    out.println(ex); }}        //catch block to handle any exception thrown during validation and provide meaningful error message       /*  }*/ };      return authentication;}