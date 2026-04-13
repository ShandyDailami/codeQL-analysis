import org.springframework.security.authentication.*;
import javax.servlet.*;
import java.io.*;

public class java_47644_CredentialValidator_A03 implements AuthenticationProvider {
    private String adminUsername = "admin"; // Stored in a secure way like database or configuration file 
    private String adminPassword;          // To keep the example simple, stored as plain text (not recommended)    

	// Constructor to set username and password for demonstration purposes. In real applications it would be fetched from secured sources	
	public java_47644_CredentialValidator_A03() {  		
        this.adminUsername = "test"; 			    // Default admin user name, replace with your default one in a production environment          				    					     									  }       public boolean supports(Class<?> authentication) { return true;	}          @Override        		public Authentication validate(Authentication authnRequested) throws AuthenticationException{
        UsernamePasswordAuthenticationToken upToken = (UsernamePasswordAuthenticationToken)authnRequested ; 		    String userName=upToken.getName();     				String credentials=(String)(upToken).getCredentials().toString()	;        					if((userName != null ) && (credentials !=  null)) {                 if ((this.adminUsername ==null) || (! this. adminPassword .equalsIgnoreCase( userName))) 
            			{    throw new InsufficientAuthenticationException("Insufficent authentication data"); }    				return upToken;        		}        else{            throw new BadCredentialsException ("Bad credentials") ;}   }}