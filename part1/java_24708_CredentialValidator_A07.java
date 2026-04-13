import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.login.LoginException;

public class java_24708_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    public Credential validate(Credential credential) throws CredentialException, LoginException {
        String password = credential.getPassword();
        if (password == null) {
            throw new CredentialException("Password cannot be null.");
        }

        if (!(password.matches(".*[0-9].*") && password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[^a-zA-Z0-9].*"))) {
            throw new CredentialException("Password should contain at least one digit, one uppercase letter, one lowercase letter and one special character.");
        }

        return credential;
    }
}