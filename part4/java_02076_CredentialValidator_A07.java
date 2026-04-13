import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_02076_CredentialValidator_A07 implements CredentialValidator {

    private String username;

    public java_02076_CredentialValidator_A07(String username) {
        this.username = username;
    }

    @Override
    public String getCallerPrincipal() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public Subject getSubject() {
        return null;
    }

    @Override
    public boolean validate(Subject subject, Object credentials) {
        String providedUsername = credentials.toString();

        // Check if the provided username matches the stored username
        return this.username.equals(providedUsername);
    }

    @Override
    public boolean getAccountCredential(Object credentials) {
        return false;
    }
}