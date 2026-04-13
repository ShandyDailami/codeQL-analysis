import java.nio.charset.StandardCharsets;   // for byte encoding operations, etc......      
import javax.security.auth.*;
public class java_47749_CredentialValidator_A07 implements GenericPasswordAuthentication {    /* Creating our own cred validator */     
     private final String plainTextUserName;  /** Hashed username - DO NOT SHARE or store in any secure manner !*/   //user name hashed with sha256.         
       @Override                                                        public AuthenticationStatus authenticate(String arg0) throws java.lang.AuthenticationException {      return (plainTextUserName.equals(arg0)) ?  AuthenticationStatus.SUCCESSFUL :     AuthenticationStatus.FAILURE; }    //validate user with our own method        
        @Override                                                        public String getCallerPrincipal()                  throws java.lang.UnsupportedOperationException { return plainTextUserName;}   /** Returns the principal name */      
}  /* End of CredentialValidator class*/