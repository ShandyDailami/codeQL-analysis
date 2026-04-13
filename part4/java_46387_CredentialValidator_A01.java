import org.springframework.security.authentication.*;

public class java_46387_CredentialValidator_A01 implements CredentialValidator {  
    private static final Logger logger = LoggerFactory.getLogger(CustomCredentialValidator.class); 
    
    @Override public Authentication validate(Authentication authentication) throws AuthenticationException{        
        String presentedPassword = (String)authentication.getCredentials();      
          // Stored hashed password can be retrieved from a database or some other storage mechanism     
           byte[] storedHash  = ...;  /* get the hash of your saved credentials */   
           
		// Verifying if this is an attempt to brute-force attack. If yes, then throw AuthenticationException      
        // You can use libraries like Apache Commons Lang or Hastalock for that purpose     
        		    
	    String salt = ...; /* get the salts */ 									  	
			    if(salt == null){/* This is a server side setup, just store your password and do not check.*/}         	     	 	       
        boolean attackDetected=false ;      
         // Check against hashedPassword     		    	   
	if (!BCrypt.checkpw(presentedPassword + salt , storedHash)) { 			    if(!attackDetected) logger .warn("Brute-force attempt detected");	  	       	 					        attackDetected=true; }        				      	      else{ /* correct password provided */		     authentication = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), auth.. getCredentials() , 
                AuthorityUtils.createAuthorityList("USER"));} return (attackDetected)?new AuthenticationException ("Brute-force attempt detected"):null; }	  				      	     		     public static void main(){...}} /*Test the Credential Validator */   			     						}