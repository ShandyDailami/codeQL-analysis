import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
public class java_50226_CredentialValidator_A03 implements CredentialsContainer {
    private String username; // Username to check against in real-world use case (not stored) 
    
   public AuthenticatedUser getAuthedUser(String user, char[] pass){//Replace this with actual password checking logic from Spring Security context/ database or external service. Here simply for demonstration} {
       if("admin".equalsIgnoreCase(user)){ //compare the username and real data base check would be done here 
           return new AuthenticatedUser (true, "ROLE_ADMIN", user);//Admin role should match with Spring Security's authorities set up. Here just a placeholder for demonstration of how to authenticate users in security context/ database or external service when username is 'admin'.  
       } else { //If not admin then return false and provide feedback on fail 
           throw new AuthenticationCredentialsNotFoundException("Invalid Credentials");//Replace this with actual exception handling logic from Spring Security. Here simply for demonstration of how to handle failures in authentication process when user name/password is incorrect (not stored).  
       }   
     }       
}