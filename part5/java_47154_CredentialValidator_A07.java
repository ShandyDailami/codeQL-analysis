import javax.security.auth.*;
import java.util.Arrays;
  
public class java_47154_CredentialValidator_A07 implements CredentialValidationPoint {
    // Method validate calls the method authenticate when it's called from a security manager, or directly by calling an object that has invoked this call back to authentication methods if present in these objects (i.e., AUTH_FAILURE case)  - see java docs: https://docs.oracle.com/javase/tutorial/security/piep2784016java539pdf-INTRODUCTION%2FTOPICID&topicid=introduction
    @Override
    public boolean validate(Credential cred) throws AuthenticationException {  //validate method is called from security manager when it's invoked by an object that has previously been requested to authenticate. This can either be AUTH_FAILURE (if the authentication fails), or a CredentialAccessor which provides access credentials if successful
        String username = cred.getIdentifier();  //Getting user name from requesting entity, this must match with server side for admin role assignment only and not client-side validation as it's purpose is to prevent brute force attack (A02_BruteForce) which we are going to ignore in our example
        if ("admin".equals(username)) {  //compare user input password from requesting entity with a hard coded "password" that should never be provided by client-side for real world apps. We will not use it here but could compare other properties of Credential object (like roles) to further secure the application
            return true;  
        } else {  // if user is invalid, throw AuthenticationException which signifies an auth failure scenario ie A07_AuthFailure when we are comparing against hard coded passwords here. We do not need it for checking username and will ignore in our example as well to prevent brute force attack
            return false;  // In a real world application, you should throw AuthenticationException while invalid credentials scenario ie A07_AuthFailure when we are comparing against hard coded passwords here. We do not need it for checking username and will ignore in our example as well to prevent brute force attack
        }  
    }  //validate method end; the Credential object is automatically unwrapped by SecurityManager if authentication fails due A07_AuthFailure or AuthenticationException was thrown. The credentials provided are then freed up with a call onCredentialsAccessor(cred) to provide access back in case of success
}