import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_25032_CredentialValidator_A07 implements LoginModule {

    private Credential credential;

    @Override
    public void initialize(CallbackHandler callbackHandler)
            throws UnsupportedCallbackException, LoginException {
        Callback callback = callbackHandler.getCallback();
        credential = (Credential) callback;
    }

    @Override
    public CredentialValidationResult validate(Credential cred) {
        if (cred == null) {
            return CredentialValidationResult.failed("No Credential provided");
        }
        
        String username = cred.getCredentialIdentifier();
        char[] password = cred.getCredential();

        if (username == null || username.isEmpty()) {
            return CredentialValidationResult.failed("Username is required");
        }

        if (password == null || password.length == 0) {
            return CredentialValidationResult.failed("Password is required");
        }

        // Simulating validation
        if ("admin".equals(username) && "password".equals(new String(password))) {
            return CredentialValidationResult.success();
        }

        return CredentialValidationResult.failed();
    }

}