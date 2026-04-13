import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;

public class java_38240_CredentialValidator_A07 implements CallbackHandler {

    private String username;
    private String password;

    public java_38240_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Credential validate(Callback callback) throws CredentialException, UnsupportedCallbackException {
        if (callback instanceof UsernamePasswordCallback) {
            UsernamePasswordCallback callbackInfo = (UsernamePasswordCallback) callback;

            String providedUsername = callbackInfo.getIdentifier();
            char[] providedPassword = callbackInfo.getPassword();

            if (this.username.equals(providedUsername) && this.password.equals(new String(providedPassword))) {
                return null; // Authentication successful
            } else {
                throw new CredentialException("Invalid username or password");
            }
        } else {
            throw new UnsupportedCallbackException(callback, "Unsupported callback");
        }
    }
}