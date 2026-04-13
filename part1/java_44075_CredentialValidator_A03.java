import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.sasl.SaslServerClient;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
 
public class java_44075_CredentialValidator_A03 implements CallbackHandler {  
    private final Set<String> acceptedActions = new HashSet<>( Arrays.asList("login")); //accepts login actions only    
     
    @Override public Callback[] getCallbacks() throws IOException, UnsupportedCallbackException 
    {        return new Callback[]{new UsernamePasswordCallback("")}; }  
         
    private boolean isActionSupported(String action)      
    {           if (acceptedActions.contains(action))             return true;            else               return false;}     
     @Override public boolean supports(String action){return this.isActionSupported(action);}  }   //end of CustomCallbackHandler class        `java'