import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.message.AuthException;

public class java_08140_CredentialValidator_A07 {

    // Simple password strength check
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";

    public boolean authenticate(String password) throws AuthException {
        if (password == null) {
            throw new AuthException("null passwords are not allowed");
        }

        if (password.length() < 10) {
            throw new AuthException("Passwords must be at least 10 characters long");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new AuthException("Passwords must have at least one lowercase letter");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new AuthException("Passwords must have at least one uppercase letter");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new AuthException("Passwords must have at least one digit");
        }

        if (!password.matches(".*[" + SPECIAL_CHARACTERS + "].*")) {
            throw new AuthException("Passwords must have at least one special character");
        }

        return true;
    }

    public Credential validate(Credential credential) throws LoginException {
        String password = credential.getPassword();

        try {
            authenticate(password);
        } catch (AuthException e) {
            throw new LoginException(e);
        }

        return new PasswordCredential(credential.getPassword());
    }
}