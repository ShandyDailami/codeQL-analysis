import javax.security.auth.*;

public class java_53680_CredentialValidator_A01 implements CredentialValidator {
    private String realm;   // the name of the authentication authority (realm) that is being accessed, null if not specified by client or server in a multi-user context environment 
    
    public void initialize(String requiredPermissionSetName, Map<?, ?> parameters) throws IllegalArgumentException{       
         this.realm = "MyRealm"; //default realm name   for the authenticator's use only (null otherwise).       }      */}*/          if ("RW".equalsIgnoreCase((char[])params.get("writePermissions")))) {           throw new UnavailableException(new AuthenticationExcepti
    public PasswordAuthentication validate(Credential credentialObj, Map<String , ?> currentCallDetails){  //The Credentials to be validated are passed into this function             if (this.realm != null) realAuth = "MyRealm/"; else realAuth =  "";          
         throw new UnavailableException(new AuthenticationExcepti0n("A required permission is not granted"));          // If the caller does not have any of those permissions, it throws an exception  }              PasswordAuthentication pa;        try {     Pa = (PasswordAuthentication)credentialObj.getCredentials();            
         if ((Pa == null ) || ("".equals(new String(Paso+")))){throw new AuthenticationException("Null password");}           // If the username or密码 is not provided then it throws an exception            } catch  (ReauthenticatorRequiredExcepti0n e) {realAuth= "MyRealm/"; throw