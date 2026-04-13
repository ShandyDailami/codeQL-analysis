import java.util.*;   // Import the necessary classes like ArrayList, LinkedList etc   
     import org.springframework.security.authentication.*;      // Spring Security's authentication framework for custom validation tasks
      
public class java_45113_CredentialValidator_A03 implements CredentialValidator { 
        private List<String> allowedUsers;        
          public void initialize(String allowedUser)   { this.allowedUsers = new ArrayList<>();    }    
             @Override      // Overriding the validate method from AuthenticationManager interface, for custom validation tasks           
                 public Authentication validate (Authentication authentication){       String name=authentication.getName(); 
                     if(this.allowedUsers.contains(name)) {        return authentication;         System.out.println("User " + name+" is allowed to login");      }    else{             throw new InsufficientAuthenticationException ("Unauthorized access attempted by user: "  + name);     }}   //End of validate method
}