import org.springframework.security.authentication.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.concurrent.ExecutionException;
 
public class java_43980_CredentialValidator_A07 implements CredentialsContainer {
    private String username = ""; //username provided by user in login form  
    	      		     	 				//can also be a principal object as well (optional)
                                          	   									        							       	       	     	         	            	}  else if ("".equals(user)) {}           	else { this.principal=new UserPrincipal(this);}    }   public boolean supports(final Authentication authentication){ return "USERNAME_PASSWORD".equals(authentication.getDetails());}}