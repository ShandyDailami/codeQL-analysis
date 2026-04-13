import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_30649_CredentialValidator_A08 implements LoginModule {

    private UsernamePasswordCredential credential;

    @Override
    public void initialize(CallbackHandler callbackHandler, Map<String, ?> properties)
            throws CredentialException, LoginException {
        // No initialization needed for this module
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        // Assume the password is always correct for this example
        if (credential.getPassword().equals("correctPassword")) {
            this.credential = credential;
            return true;
        } else {
            return false;
        }
    }

    public UsernamePasswordCredential getCredential() {
        return credential;
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public String getName() {
        return "Legacy Credential Validator";
    }
}