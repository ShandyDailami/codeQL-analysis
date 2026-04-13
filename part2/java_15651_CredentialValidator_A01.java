// Import the necessary classes
import java.util.Base64;
import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_15651_CredentialValidator_A01 implements CredentialValidator {

    private String username;
    private String password;

    public java_15651_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Override the getPassword and getUsername methods
    @Override
    public String getPassword(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        return this.password;
    }

    @Override
    public String getUsername(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        return this.username;
    }

    // Override the validate method
    @Override
    public boolean validate(Subject subject, Credential credential) {
        String providedUsername = credential.getIdentifier();
        String providedPassword = credential.getPassword();

        return this.username.equals(providedUsername) && this.password.equals(providedPassword);
    }
}