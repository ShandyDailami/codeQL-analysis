import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_19218_CredentialValidator_A03 implements LoginModule {

    private Credential credential;

    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        Callback callback = callbackHandler.getCallback();

        // validate the username
        String username = callback.getUsername();
        if (!username.matches("^[a-zA-Z0-9]+$")) {
            return CredentialValidationResult.failure();
        }

        return CredentialValidationResult.success();
    }

    public void initialize(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        // no-op
    }

    public void uninstall(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        // no-op
    }

    public Credential getCredential() throws LoginException {
        return this.credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}