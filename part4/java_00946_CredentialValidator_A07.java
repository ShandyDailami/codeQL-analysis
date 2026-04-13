import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.CredentialException;

public class java_00946_CredentialValidator_A07 implements CredentialValidator {

    private String username;

    @Override
    public boolean validate(CallbackHandler callbackHandler, Credential credential) throws CredentialException, UnsupportedCallbackException {
        // Store the username in the callback
        Credential credentialInfo = (Credential) callbackHandler.getCallback();
        username = credentialInfo.getPassword();

        // Check if the stored username matches the given one
        return username.equals(credential.getPassword());
    }
}