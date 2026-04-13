import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_24322_CredentialValidator_A01 implements CredentialValidator {

    private String username;
    private char[] password;
    private Subject subject;

    public java_24322_CredentialValidator_A01(String username, char[] password, Subject subject) {
        this.username = username;
        this.password = password;
        this.subject = subject;
    }

    @Override
    public Credential validate(CallbackHandler callbackHandler)
            throws LoginException, UnsupportedCallbackException {
        // No real authentication here, just checking for username and password
        if (username.equals(new String(password))) {
            return new UsernamePasswordCredential(username, password);
        } else {
            throw new LoginException("Authentication failed");
        }
    }
}