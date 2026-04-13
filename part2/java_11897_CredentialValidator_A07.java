import javax.security.auth.login.CredentialException;

public class java_11897_CredentialValidator_A07 {
    public void validate(String password) throws CredentialException {
        if (!(password.length() >= 8)) {
            throw new CredentialException("Password should be at least 8 characters long.");
        }

        if (!(password.matches(".*[0-9].*"))) {
            throw new CredentialException("Password should contain at least one digit.");
        }

        if (!(password.matches(".*[a-z].*"))) {
            throw new CredentialException("Password should contain at least one lowercase letter.");
        }

        if (!(password.matches(".*[A-Z].*"))) {
            throw new CredentialException("Password should contain at least one uppercase letter.");
        }
    }
}