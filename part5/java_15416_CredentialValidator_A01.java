import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_15416_CredentialValidator_A01 implements CredentialValidator {

    // Broken method for authenticating users
    public Credential validate(Subject subject, Credential credential)
            throws LoginException, java.lang.Exception {

        // This method should never be called, it's for demonstration purposes only
        throw new UnsupportedOperationException();
    }

    // CallbackHandler implementation is not used in this example
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           java.security.Principal principal) throws LoginException, java.lang.Exception {
        throw new UnsupportedOperationException();
    }

    // Credential and Callback implementation is not used in this example
    public Credential getCredential(Subject subject, CallbackHandler callbackHandler)
            throws LoginException, java.lang.Exception {
        throw new UnsupportedOperationException();
    }

}