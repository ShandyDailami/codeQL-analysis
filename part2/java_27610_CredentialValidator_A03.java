import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_27610_CredentialValidator_A03 implements LoginModule {

    private String username = "user";
    private String password = "password";

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, String> options) throws LoginException, UnsupportedCallbackException {
        // No setup to be done in this example
    }

    @Override
    public boolean validate(Subject subject, UsernamePasswordCredential credential) throws CredentialException {
        // Validate the username and password
        return credential.getUsername().equals(username) && credential.getPassword().equals(password);
    }

}