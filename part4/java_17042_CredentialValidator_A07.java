import java.util.regex.Pattern;

import javax.security.auth.CredentialValidationResult;
import javax.security.auth.password.PasswordValidator;
import javax.security.auth.password.ValidationResult;

public class java_17042_CredentialValidator_A07 implements PasswordValidator {
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[^a-zA-Z0-9]");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]");

    @Override
    public ValidationResult validate(CredentialCredential credential) {
        String password = credential.getPasswordData().toString();

        if (password.length() < 8) {
            return ValidationResult.failed("Password should be at least 8 characters long");
        }

        if (!SPECIAL_CHAR_PATTERN.matcher(password).find()) {
            return ValidationResult.failed("Password should contain at least one special character");
        }

        if (!UPPERCASE_PATTERN.matcher(password).find()) {
            return ValidationResult.failed("Password should contain at least one uppercase letter");
        }

        if (!LOWERCASE_PATTERN.matcher(password).find()) {
            return ValidationResult.failed("Password should contain at least one lowercase letter");
        }

        if (!NUMBER_PATTERN.matcher(password).find()) {
            return ValidationResult.failed("Password should contain at least one number");
        }

        return ValidationResult.success();
    }
}