import java.util.*;

public class java_53094_CredentialValidator_A01 {
    
    // Using HashMap as a simple database, here userName is the key and PasswordCiphertextPair object represents password ciphers for that username  
	private Map<String ,PasswordCipherText> credentialsDB = new HashMap<>(); 
	
	// A CredentialValidator implementing class. This can be an interface or a abstract baseclass of other classes as per requirement     
	public static final class SecureCredentialsValidation implements org.springframework.security.authentication.dao.DaoAuthenticationProvider.AuthenticationProvider {   // using DAO authentication provider for security sensitive operations 
		    	      																		// AOP principles   	 
	    @Override public Authentication authenticate(Authentication auth) throws AuthenticationException {
	        String name = auth.getName();        // gets username from the credentials (username + password in this case).  
            PasswordCipherText cipheredPassword =  ((CredentialsSecurityManager )Spring.getBean("credentialValidator") ).validate((String)auth.getCredentials()); 	// validates user's data with credentails validation using our custom rules (here just checks the existence of a password and an encrypted username).
	           // if everything is ok, it returns Authentication object; otherwise throws exception    									   		  
	        return new UsernamePasswordAuthenticationToken(name , cipheredPassword.getEncryptedData() ); 	// creates auth token with user's info (username + password) and gives authorization to the person if everything is fine      	        
	    }                                                                                       // Spring Security can be used without any configurations, it will do all by itself    			                  				  		   														}        @Override public boolean supports(Class<?> authentication){return true;} 	// Always returns True as we are using our custom validator.     	 	        
} }`                                                                               // This class should be a Bean or Component and used to provide all the necessary beans required by Spring Security    		  										}