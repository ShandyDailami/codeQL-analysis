import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
  
public class java_45663_CredentialValidator_A07 implements AuthenticationProvider {    
    @Override            
    public Authentication authenticate(Authentication authentication) throws AuthenticationException  {       
       String name = authentication.getName();        
       String password = authentication.getCredentials().toString();         
               
      if (isValidUserNameAndPassword(name,password))   //validate the user credentials    
           return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), null);            
        else  {           
               throw new AuthenticationException("Invalid Credentials"){};             
         }         
    }     
       @Override                  public boolean supports(Class<?> authentication)   //check the supported class for this provider           return true;    
}                                                   private boolean isValidUserNameAndPassword (String name, String password){  /*return value based on condition of your validation logic*/         if("user".equalsIgnoreCase(name ) && "password".equals(password))          {             System.out.println ("Validation successful");           return true;        }            else  
       {     //display a custom message for invalid user and password here    throw new AuthenticationException (“Invalid Credentials”);  }}                private class UsernamePasswordAuthenticationToken implements AuthenticationToken{ @Override public Object getPrincipal() throws IllegalArgumentException, UnsupportedOperationException { return ""; }@ Override public Object getCredentials()throws IllegalArgumentException ,UnsupportedOperationException
        Returns null;}}}}}      //end of code snippet.  Please note that this is a simple validation and should be expanded upon as per your requirements in real-world scenarios according to A07_AuthFailure criteria for security sensitive operations related to authentication failure handling, custom error messages etc.. This sample does not use any Spring libraries but it includes their dependencies through Maven file.