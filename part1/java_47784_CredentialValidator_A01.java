import javax.security.auth.*;

public class java_47784_CredentialValidator_A01 {    
    public boolean validate(String user, String password) throws AuthenticationFailedException{        
        // Assume a basic validation here - check if the username and password are not nulls or empty strings         
		if (user == null || user.trim().isEmpty() || 
            password==null||password.trim().isEmpty()) {            
		   throw new AuthenticationFailedException("Invalid Credentials");			 
        }        
       // Now, perform actual check in database here - for this example we just return true if username and Password match         
		return user.equalsIgnoreCase(password);          
    }}