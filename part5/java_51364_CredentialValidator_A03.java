import javax.security.auth.*;
import java.util.Arrays;
import sun.security.provider.SunPKCS15Provider;
public class java_51364_CredentialValidator_A03 implements CredentialValidator {
    @Override public AccessControlContext validate(AccessControlContext context) throws AuthenticationException, LoginException{
        if (context == null){ // no credentials provided by the client – reject request for an anonymous user.
            throw new IllegalArgumentException("Missing creds");  
         }else{           /* check authentication mechanism used */    
             String authMechanism = context .getAuthInfo().getClass().getName();   
                 if(authMechanism==null || ! (Arrays.asList ("S", "Kerberos", 	"DIGEST-MD5"	,   // supported mechanisms... see SunPKCS15Provider for complete list)) .contains ((String) authMechanism)){   
                     throw new LoginException("Unsupported authentication mechanism");       }          /* if not one of the support'd ones.. */     else { context = null;  }}             return (null);}}      @SuppressWarnings ("unused") public static void main(String[] args) throws Exception{
        LegacyCredentialValidator validator=new LegacyCredentialValidator();    //creating instance of credentialvalidatorserver... }   private SunPKCS15Provider provider = new sun.security.pkcs11.SunPKCS15Provider ();}  /* provide the location for your token store */}}