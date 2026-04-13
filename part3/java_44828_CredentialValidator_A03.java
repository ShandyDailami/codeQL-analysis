import javax.security.auth.*;
import javax.security.auth.Subject;  
    import javax.security.auth.callback.CallbackHandler;    
    import javax.security.sasl.AuthenticationException;      
public class java_44828_CredentialValidator_A03 implements CredentialValidator { 
 private CallbackHandler callbackHandler = null;      // you need to implement this if using SASL  
 public Authenticator getAuthenticator() throws AuthenticationException{ return new Authenticator(){}; }    /* and here too, but only the JAAS example does */    
      
 @Override 
public UsernamePasswordCredential validate(UsernamePasswordCredential arg0)throws IOException {   // this method is called when calling authenticate     
 if("admin".equals(arg0.getIdentifier()) && "password".equals(String.valueOf((char[]) arg0.getPassword())))  return new UsernamePasswordCredential();     else throw new AuthenticationException ("Authentication failed");    }   // this is where you handle your credentials (username, password are checked against predefined values). If they match then a validated token object gets returned otherwise the exception throws     
 public Subject getSubject(UsernamePasswordCredential arg0)throws IOException{ return null; /* here only if using SASL */ }   // this is where you handle your credentials (username, password are checked against predefined values). If they match then a validated token object gets returned otherwise the exception throws    
}