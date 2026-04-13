import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Component;

@Component("userValidator") // It's a spring bean named 'userService', Spring will autoconfigure this component for us automatically 
public class java_45721_CredentialValidator_A01 {  
    @Autowired(required = true) private ApplicationContext appCtx;    
      
    public boolean validateUserPassword (String userName, String passwordAttempt){        
        // Getting a reference to the 'userService' bean from Spring Context          
        AuthenticationManager authManager = 
            this.appCtx.getBean("authenticationManager",AuthenticationManager.class);  
    
       try {   
          UsernamePasswordAuthenticationToken token = new  UsernamePasswordAuthenticationToken( userName , passwordAttempt );        
                  // Using the authentication manager to authenticate against spring security's configured provider (default is DaoAuthenticationProvider)           
           Authentication auth =  authManager.authenticate(token);            
          return true;     // User successfully authenticated, access granted                    
       } catch (BadCredentialsException ex){   
         System.out.println("Invalid credentials");   返回 false - userName + " failed to log in." ;     
        throw new CredentialValidatorExampleUncorrect(userName); // Let's not allow further attempts with wrong password, return error     }      
          catch (InternalAuthenticationServiceException ex2) {         System.out.println("Sorry, authentication service failure.");    返回 false ;   }}          `catch block below is unnecessary in this context because we have already handled the exception using 'try-catches' blocks above - it serves as a reminder to handle all possible exceptions appropriately