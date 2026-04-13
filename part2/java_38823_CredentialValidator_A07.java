import java.security.auth.Credential;
import java.security.auth.CredentialValidationResult;
import java.security.auth.PasswordAuthentication;
import java.util.regex.Pattern;

public class java_38823_CredentialValidator_A07 implements CredentialValidator {

    // Regular expression for matching password pattern
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String password = credential.getPassword();

        // Check password length
        if (password.length() < 8 || password.length() > 32) {
            return CredentialValidationResult.failed();
        }

        // Check password contains uppercase, lowercase, number, special character
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            return CredentialValidationResult.failed();
        }

        // If all conditions are met, return successful result
        return CredentialValidationResult.success();
    }
}