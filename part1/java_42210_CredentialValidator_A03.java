import javax.security.auth.*;
    import java.util.*;
    
public class java_42210_CredentialValidator_A03 implements javax.security.auth.CredentialValidator {
        private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()=<>?"; // A03: injection point here 
        
    public ArrayList<String> getPassword(AuthToken arg) throws AuthenticationException{  
    	ArrayList <String> passList  = new ArrayList  <String> ();//Avoids Injection attacks. Not using external database for random password generation due to security purpose, only storing strings in list 
        String generatedPass;    // A03: injection point here - no use of Random() method directly into this variable    
        	  		      										// This is the main attack area when you inject data through arg parameter. Not using secure random number generation for passwords only storing as string and not used in database access 			       	 	    }             passList .add (generatedPass);          return      null;    }}    
}