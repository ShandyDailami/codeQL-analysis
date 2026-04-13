public class java_44120_CredentialValidator_A08 implements CredentialValidator {
    private static final Logger logger = LoggerFactory.getLogger(CustomCredentialsValidator.class);
    
    // pre-defined set of rules for password validation (this is not secure) - replace with real logic later in code 
    List<String> validPasswords;  
      
      public java_44120_CredentialValidator_A08() {        
        this.validPasswords = new ArrayList<>();         
           }    
           
public void addValidPassword(final String password){              
this.validPasswords .add (password);  // Store all pre-defined valid pass phrases   for security purpose             
}      
    @Override      public boolean validate(CredentialContext context) throws CredentialValidationException {        
        UsernamePasswordCredential creds = (UsernamePasswordCredential)context.getCredentials();         
            String passwordAttempt =  new String((creds.getID()));              // get the pass in clear text      
             if(this.validPasswords .contains(passwordAttempt)) {                 return true; } else{                  logger.warn("Invalid credentials: "+ creds); throw new CredentialValidationException ("INVALID_PASSWORD");   }}          @Override      public void validate(CredentialContext context, UsernamePasswordCallback callback) throws IOException, CredentialValidationException  {    // Not used in this example     }
}