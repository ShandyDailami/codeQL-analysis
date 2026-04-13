import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

public class java_38246_CredentialValidator_A01 implements CredentialValidator {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(Subject subject, Credential credential)
            throws LoginException {
        String username = credential.getIdentifier();
        String password = (String) credential.getCredential();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}