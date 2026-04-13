import javax.security.auth.message.MessageIssuerSecurityException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_07995_CredentialValidator_A03 implements CallbackHandler {

    @Override
    public Credential retrieveCredential(Subject subject, String username, String password) throws LoginException, UnsupportedCallbackException {
        // Here, we create a credential object
        return new UsernamePasswordCredential(username, password.toCharArray());
    }
}

public class MyCredentialValidator {

    private MyCallbackHandler callbackHandler;

    public java_07995_CredentialValidator_A03() {
        callbackHandler = new MyCallbackHandler();
    }

    public void validate(Subject subject, String username, String password) throws MessageIssuerSecurityException, LoginException {
        Credential credential = callbackHandler.retrieveCredential(subject, username, password);
        
        // Perform your security sensitive operation here
        // ...
        
        // If the operation is successful, return true
        // If not, throw an exception
        throw new MessageIssuerSecurityException("Success!");
    }
}