import javax.security.auth.*;
import javax.security.auth.Subject;

public class java_49871_CredentialValidator_A01 implements CredentialValidator {
    private Subject subject; // to store current authenticated user's info about their authentication status and identity, etc... in real world scenarios it will be null at the start of each request/session.. 
    
	public void validate(Credential cred) throws InvalidCredentialException{  	        
	    if (cred instanceof UsernamePasswordCredential){    // check which type credentials are passed. We only allow username and password for now...      		            	     	 			       				         					           } else {  throw new UnsupportedOperationException();}    	        subject = null; }}                  public Subject getSubject(){ return this.subject;}