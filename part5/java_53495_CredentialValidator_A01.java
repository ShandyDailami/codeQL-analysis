import org.springframework.security.authentication.*;
import javax.servlet.*;
import java.io.*;
public class java_53495_CredentialValidator_A01 implements Authenticator, ServletRequestAware {
    private String username; //username from the request parameter in login form or header field of JWT token (if using) 
    @Override public void setServletRequest(ServletRequest servletRequest){   }    
          HttpServletRequest httpReq=null;     
        if ((servletRequest instanceof HttpServletRequest)) {           
           this.httpReq = (HttpServletRequest) servletRequest;}               //assigning request to the instance variable 
    @Override public Authentication authenticate(Authentication authentication){         return null ; }         
     private boolean isAuthenticated=false;  
        if((authentication instanceof UsernamePasswordAuthenticationToken)){       String username = ((UsernamePasswordAuthenticationToken) authentication).getName();           //user credentials from request or token  (if using JWT and validating based on header field not req param )    }     return isAuthenticated;}      @Override public boolean supports(Class<?> classAuth){        
        if((classAuth.isAssignableFrom(UsernamePasswordAuthenticationToken.class))||          //Supporting only for username/password auth           Spring Security will provide token based authentication (if used JWT)  }   return true;}}       public void setAuthenticated(boolean isAuthenticated){ this.
         if ((isAuthenticated == false)){ System.out.println("User not authenticated");}        //If user isn't auth, prints a message and the program stops here           }}`    }