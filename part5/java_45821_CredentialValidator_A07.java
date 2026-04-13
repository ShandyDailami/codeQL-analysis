import javax.security.auth.*;
import javax.security.auth.login.LoginException;
    
public class java_45821_CredentialValidator_A07 implements CredentialValidator {
    public LoginContext validate(Subject subject, Object credentials) throws LoginException {        
        String username = (String)(credentials); // getting the input parameters of type string 
            
	    if ("admin".equalsIgnoreCase((username)))      	// checking for admin user    	  		         
            return new LoginContext("Admin", "A07_AuthFailure");   			                  									                 	 	      }        
        else {                       // If not an Admin, it will be a normal non-admin login.               	       								 	   	}     	return null; }}                                         The above code is for demonstration purpose only and does not involve any external libraries or frameworks like Spring OR Hibernate in this case as you requested.