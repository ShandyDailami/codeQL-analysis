import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_35285_CredentialValidator_A03 implements javax.security.auth.credential.CredentialValidator {

    @Override
    public Credential validate(Credential credential) throws LoginException {
        String username = credential.getUsername();
        String password = credential.getPassword();

        if ("testuser".equals(username) && "testpassword".equals(password)) {
            return new UsernamePasswordCredential("testuser", "testpassword".toCharArray());
        } else {
            throw new LoginException("Invalid credentials");
        }
    }

    @Override
    public void initialize(Subject subject, String arg1, Credential attributes) throws LoginException {
        // This method is called when the validator is initialized, but not when the subject's credentials are changed.
    }

    @Override
    public void refresh(Subject subject, String arg1) throws LoginException {
        // This method is called when the subject's credentials are changed.
    }

    @Override
    public boolean validate(Subject subject, String usernameAttribute, X500Principal domain, Credential credentials) throws LoginException {
        // This method is called to validate the credentials after the subject's credentials have been changed.
        return true;
    }
}