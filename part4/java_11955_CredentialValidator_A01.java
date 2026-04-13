import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Collections;

public class java_11955_CredentialValidator_A01 implements javax.security.auth.credential.CredentialValidator {

    private String expectedUsername;
    private String expectedPassword;

    public java_11955_CredentialValidator_A01(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public Credential validate(Credential credential) throws LoginException, IOException, UnsupportedCallbackException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;
            if (upCredential.getIdentifier().equals(expectedUsername) && upCredential.getPassword().equals(expectedPassword)) {
                return upCredential;
            } else {
                throw new LoginException("Invalid username or password");
            }
        } else {
            throw new UnsupportedCallbackException("Unsupported credential type: " + credential.getClass().getName());
        }
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) throws LoginException, UnsupportedCallbackException {
        // Not implemented
    }
}