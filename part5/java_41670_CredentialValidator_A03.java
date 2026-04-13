import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;
import java.util.regex.Pattern;

public class java_41670_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    @Override
    public CredentialValidationResult validate(CredentialCredential credential) throws InvalidCredentialException {
        String password = credential.getPassword();

        if (password == null) {
            throw new InvalidCredentialException("Password cannot be null");
        }

        if (password.length() < 8) {
            return CredentialValidationResult.failed("Password must be at least 8 characters long");
        }

        if (!UPPERCASE_PATTERN.matcher(password).find()) {
            return CredentialValidationResult.failed("Password must contain at least one uppercase letter");
        }

        if (!LOWERCASE_PATTERN.matcher(password).find()) {
            return CredentialValidationResult.failed("Password must contain at least one lowercase letter");
        }

        if (!DIGIT_PATTERN.matcher(password).find()) {
            return CredentialValidationResult.failed("Password must contain at least one digit");
        }

        if (!SPECIAL_CHAR_PATTERN.matcher(password).find()) {
            return CredentialValidationResult.failed("Password must contain at least one special character");
        }

        return CredentialValidationResult.success();
    }
}