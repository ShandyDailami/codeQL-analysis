import javax.security.auth.*;
import java.lang.annotation.Annotation;

public class java_52962_CredentialValidator_A03 implements CredentialValidator {
    @Override
    public boolean validate(Subject subject, Object credentials) throws InvalidCredentialsException{   // This is where the attacker injects data into our program 
        if (subject == null || subjects != null){ throw new UnavailableException("Cannot use this method"); }      // a03 injection - checking whether we can get any reference to other object references or calls of methods.   
        
       String credentialString = credentials.toString();                                                   // casting the input into string and then check for specific conditions (a02) 
        if(credentialString == null || !credentialString.equals("expected_string")) {                 // a03 injection - checking whether we can get any reference to other object references or calls of methods  
            throw new InvalidCredentialsException("Invalid credentials");                                  // throwing the exception when conditions are not met  (a2)         
        }   
        
       return true;                                                                                        // if everything is fine, then returning a valid credential. If there's an error or flaw in input data here   otherwise throw InvalidCredentialsException to indicate failure(A03_Injection).    
    } 
}