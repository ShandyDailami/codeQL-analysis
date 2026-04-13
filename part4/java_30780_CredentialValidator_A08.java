import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordCredentials;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.Serializable;

public class java_30780_CredentialValidator_A08 implements CredentialValidationResult, CallbackHandler, Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private char[] password;

    public java_30780_CredentialValidator_A08(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public CredentialValidationResult validate(CallbackHandler callbackHandler)
            throws IOException, LoginException, UnsupportedCallbackException {

        // Use a simple username/password validation
        if (username != null && username.equals("admin") && new String(password).equals("password")) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
}