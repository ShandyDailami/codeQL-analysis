import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;
import java.util.regex.Pattern;

public class java_12675_CredentialValidator_A01 implements CredentialValidator {

    // Regular expression for checking password strength
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) throws CredentialException {
        String username = credential.getUsername();
        String password = credential.getPassword();

        if (username == null || username.trim().isEmpty()) {
            throw new CredentialException("Username cannot be empty");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new CredentialException("Password cannot be empty");
        }

        if (!USERNAME_PATTERN.matcher(username).matches()) {
            throw new CredentialException("Username must contain only alphanumeric characters and underscore");
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new CredentialException("Password must contain at least one number, one uppercase letter, one lowercase letter, one special character, and at least 8 characters long");
        }

        return new CredentialValidationResult("Success", null);
    }
}