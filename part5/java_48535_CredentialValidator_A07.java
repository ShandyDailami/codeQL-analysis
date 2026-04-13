public class java_48535_CredentialValidator_A07 implements CredentialValidator {  
    private static final Logger logger = LogManager.getLogger(CustomCredentialValidator.class);  
      
    @Override public boolean validate(UsernamePasswordCredential cred) throws AuthenticationException {    
        String userName=cred.getIdentifier();  // getting username from authentication token (here assumed to be JWT in your case).     
        
        if("admin".equalsIgnoreCase(userName)){    //check with admin credentials  
            logger.info ("Admin account authenticated successfully");    
            return true;          } else {              
           throw new AuthenticationFailedException();  /* Unsuccessful authentication */      
              }      }         @Override public boolean reauthenticate(UsernamePasswordCredential arg0) throws AuthenticationException{    //re-auth not required for our example  
                return false; }}`