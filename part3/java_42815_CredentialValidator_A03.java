import javax.security.auth.*;
import javax.security.auth.login.LoginException;

public class java_42815_CredentialValidator_A03 implements CredentialValidator {  
    @Override 
	public boolean validate(Subject subject, Object credentials) throws LoginException{     
        // Here we'll just assume that if the creds is "admin" they are valid          
		if("admin".equals((String)credentials)){            
            System.out.println("Credential Validated Successfully");  
			return true;         }          else {              
				// Credentional information was incorrect so login fails              return false;} 	}       protected class MainClass{     public static void main( String[] args ) throws LoginException, NotAuthorizedException    {                   new CustomCredentialValidator().validate (new Subject("user"), "admin"); }} }