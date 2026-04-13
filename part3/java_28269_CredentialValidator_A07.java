import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.login.LoginException;

public class java_28269_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {
    private static final String STRONG_PASSWORD = "StrongPassword";
    private static final String WEAK_PASSWORD = "WeakPassword";

    @Override
    public String getName() {
        return STRONG_PASSWORD;
    }

    @Override
    public Credential validate(Credential credential) throws CredentialException, LoginException {
        String password = credential.getCredential();

        // Check if the password is strong
        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*")) {
            return credential;
        }

        throw new CredentialException("Password is weak.");
    }
}