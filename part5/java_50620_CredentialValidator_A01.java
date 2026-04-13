public class java_50620_CredentialValidator_A01 implements javax.security.auth.credential.CredentialValidator {
    @Override
    public boolean validate(javax.security.auth.credential.Credentials credentials) throws IllegalArgumentException, java.sql.SQLException{      
        // Simulate a security-sensitive operation: checking if username matches password with hardcoded values 
         String userPassword = "password";  
		 return (((String)((javax.security.auth.credential.Credentials) credentials).getCredentialId()) .equals("user"));     // Broken Access Control condition here   	
	}       	 
}