import javax.security.auth.CredentialValidator;
import javax.security.auth.Subject;
import java.security.auth.PasswordAuthentication;

public class java_04365_CredentialValidator_A08 implements CredentialValidator {

    // A pattern to match passwords
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public PasswordAuthentication validate(Subject subject, Credential credential) {
        String password = credential.getCredentialIdentifier();
        if (!password.matches(PASSWORD_PATTERN)) {
            return null;
        }
        return new PasswordAuthentication(password, null, null, null, null, null);
    }

    @Override
    public void initialize(Subject subject, Credential credential) {
        // No initialization required
    }
}