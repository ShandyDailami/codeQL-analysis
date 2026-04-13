import java.util.Base64;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.login.LoginException;

public class java_16851_CredentialValidator_A07 implements CredentialValidator {

    public Credential validate(Subject subject, Credential credential)
            throws CredentialException, LoginException {

        String user = null;
        String password = null;

        // Extract the username and password from the credential
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential userCredential = (UsernamePasswordCredential) credential;
            user = userCredential.getIdentifier();
            password = new String(Base64.getDecoder().decode(userCredential.getPassword()));
        } else {
            throw new CredentialException("Unsupported credential type");
        }

        // Validate the username and password
        if ("admin".equals(user) && "password".equals(password)) {
            return new UsernamePasswordCredential(user, password);
        } else {
            throw new CredentialException("Invalid credentials");
        }
    }

    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            public CredentialValidationResult validate(Callback[] callbacks)
                    throws CredentialException, LoginException {
                return new CredentialValidationResult("Success");
            }
        };
    }
}