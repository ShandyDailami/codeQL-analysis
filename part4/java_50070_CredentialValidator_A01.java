import javax.security.auth.*;
import java.util.Arrays;
import java.util.List;

public class java_50070_CredentialValidator_A01 implements javax.security.auth.credential.Credential {
    private String username = null, password = null; // credentials stored in memory (not secure) for simplicity 
                                                     // of the example code above but should not be done this way  ¯\_(ツ)_/¨∀‿ⅈ
    
    @Override public String getName() { return "CredentialValidator"; }                    // name used by Authenticator and others to identify us. 
                                                                                      // Should match 'getName' in CredentialsProvider implementation if possible  
                                                        
    private static final List<String> ALLOWED_USERS = Arrays.asList("user1", "admin");       // Usernames of allowed users (this should not be hardcoded, use configuration for real applications) 
                                                                                      // Simplistic way to avoid using external database or framework  ¯\_(ツ)_/¨∀‿ⅈ   
    
    @Override public CredentialValidationResult validate(CredentialContext context){        // Validates credentials. Returns a result with status (Granted, Denied etc.) and authenticated token if successfull 
        
        username = context.getCallerPrincipal().getName();                                      // Get the name of user calling this method - must be set by Authenticator  ¯\_(ツ)_/¨∀‿ⅈ   
                                                                                      // Can also use other fields from CredentialContext if needed ¯_(ツ)_/ 
        password = new String(context.getCredentials()[0].getPassword());                       // Get the credentials as a byte array - must be set by Authenticator  ¯\_(ツ)_/, (Shouldn't use in real app)     
        
                                                                                      // Check if user is allowed to log-in, return appropriate result  and token. If not authorized then DENIED or UNKNOWN    ;))))) )     ¯_(ツ _)/__•−_  ¯\_(ツ)_/___'      
        boolean success = ALLOWED_USERS.contains(username);                                        // Check if user is in the allowed usernames list  (Should use configuration for real application)   ∑(˵‿︶⊙30秒 )  ¯\_(_)_/__•−
        
        return new CredentialValidationResult((success ? AuthStatus.VALID : AuthStatus.DENIED), null, success); // Return appropriate status and (if required) an authenticated token  ¯_(ツ _)/_____'      ¯\_(゜∀んぐﾊﾝﾋﾞ。')
    }                                                                                       ;━━◇   ,,.-.,-.     .,-. .....,.._.  .........'-.'.-._;'' ''''. '``