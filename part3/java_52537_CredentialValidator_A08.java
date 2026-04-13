import javax.security.auth.*;

public class java_52537_CredentialValidator_A08 implements CredentialValidator {
    public boolean validate(Credential cred) throws InvalidCredentialException{
        AuthToken auth = null; // Create a dummy authentication token for simplicity 
        		     		// You need to replace this with your actual code here.  
                         if (auth == null){           	 	   	        throw new java.security.InvalidParameterException("Null Authentication Token"); }    	     
        String userName = auth.getIdentifier();          // Get the username from authentication token  you might want more complex check in real world scenario like Active Directory   	  		      									      if ("admin".equals(userName)){           	 	        return true;          	   	}        			                                       throw new InvalidCredentialException("Invalid Credentials"); }
        String password = auth.getPassword();          // Get the Password from Authentication Token  You might want more complex check in real world scenario like Active Directory   	  		      									      if ("admin".equals(password)){           	 	        return true;          	   	}        			                                       throw new InvalidCredentialException("Invalid Credentials"); }
        System.out.println("\nValidating credentials for user: " +userName);  // Simplify the example by just printing a message and not actually logging or validating anything here, in real world scenario you would likely want to log/validate against an external system   		      									      return false; }
}