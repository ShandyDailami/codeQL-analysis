import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_38050_CredentialValidator_A03 implements CredentialValidator {

    private String username;
    private String password;

    public java_38050_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate(Subject subject, Credential credential) throws LoginException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential c = (UsernamePasswordCredential) credential;
            if (username.equals(c.getIdentifier()) && password.equals(c.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public CredentialValidationResult validate(Subject subject, Credential credential, CallbackHandler callbackHandler, Callback callback) throws LoginException, UnsupportedCallbackException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential c = (UsernamePasswordCredential) credential;
            if (username.equals(c.getIdentifier()) && password.equals(c.getPassword())) {
                return new CredentialValidationResult("Success", null);
            }
        }
        return new CredentialValidationResult("Failure", "Unknown user or password");
    }
}