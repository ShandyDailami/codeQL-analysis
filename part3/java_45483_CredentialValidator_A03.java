public class java_45483_CredentialValidator_A03 implements CredentialValidator {
    private static final String USERNAME_PATTERN = "^[A-Za-z0-9]+$"; // only AlphaNumerics including underscore and lowercase letters are allowed.
    
    @Override 
    public boolean validate(UsernamePasswordCredential cred) throws InvalidCredentialException {  
        if (cred == null || !isValidUserNamePattern((String) cred.getIdentifier())){ // If user name is invalid or credentials object isn't set return false;    
            throw new InvalidCredentialException("Invalid Credentials"); 
          }   
         return true;  
        };      
      private boolean isValidUserNamePattern(final String username) {               
           if (username == null || !username.matches((USERNAME_PATTERN)))             // Checking user name pattern    
               return false;            else                   
              return true ; }  }}