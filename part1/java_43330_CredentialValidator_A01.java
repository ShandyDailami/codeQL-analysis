import org.springframework.security.authentication.*;
import java.util.logging.*;   // for Logger, which implements INFO level logging mechanism from Java's Util package (INFO is used here as it provides a way of saying 'informational message') 
    
public class java_43330_CredentialValidator_A01 extends CredentialsValidator {    /* Define our own credentials validator */        
   private static final Logger logger = Logger.getLogger(VanillaJavaCredentialValidator.class); // Initialize a new instance of the log file using java's logging mechanism 
     
     @Override       /* Override 'validate method in Credentials Validate class to add our custom logic */        
     public Authentication validate(Authentication auth) {         
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)auth;   // Cast the given authentication object 
           if ("admin".equals(token.getPrincipal())){                 /* Check for an username and password that are 'equal' to admin */             logger.info("Validating credentials...");    return auth;}          else {              Logger.getAnonymousLogger().log(Level.INFO, "Invalid access attempt"); 
           throw new BadCredentialsException ("Bad Credential Exception" );}     /* If not authenticated then log an error message and stop the process */         }      protected Authentication getAuthenticationFailureHandler() {    // Return a custom implementation of authentication failure handler (this is required because default one does nothing here)
        return null;  }}