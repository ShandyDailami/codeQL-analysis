import javax.security.auth.*;
import javax.security.auth.message.AppLoginModule;
import javax.security.sasl.SaslClient;
public class java_44060_CredentialValidator_A07 implements CredentialValidator {
    public AuthStatus validate(Credential cred) throws AuthenticationException{        //1st step: authentication and authorization (A07_AuthFailure).  This method returns a status of the auth request e.g., AUTH_SUCCESS, AUTH_FAILURE etc..    
         if ("admin".equals(cred.getCaller()) && "password".equals(cred.getToken())) {    //2nd step: authentication (A05).  This method checks the credentials provided by user and returns true or false based on it's valid/invalid status, in this case we are checking if they matches with our predefined ones
             return AuthStatus.VALID;        } else{           // If not matched then fail here(i.e., A06)  Here returning failed authentication i.e invalid credentials     
            System.out.println("Invalid Credentials");         
              throw new AuthenticationException("Unknown user or password.");       return AuthStatus.FAILURE;   }        // If any failure happened before, we will handle it here and let the caller know about what went wrong (A08)  Finally this method always returns either VALID/VALID_SESSION(if valid session exists after successful authentication), FAILURE or UNKNOWN
    }}       void setRealm(String s){}          //This is used to specify an alternative realm name for the CredentialValidator (A09). This would be optional.  It's not commonly needed and hence it has been left out of this example      AppLoginModule getCredentials(){return null;}       SaslClient createSaslClient(String mechanism){ return null;}}