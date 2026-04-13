import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_35629_CredentialValidator_A01 {
    public boolean validate(String username, String password) {
        Credential credential;

        try {
            credential = new UsernamePasswordCredential(username, password);
            // If the login is successful, the Credential object is valid.
            return true;
        } catch (LoginException | FailedLoginException e) {
            // If the login is not successful, the Credential object is not valid.
            return false;
        }
    }
}