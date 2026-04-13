import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.Sphere;

public class java_26023_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate( javax.security.auth.Credential credential ) {
        String password = credential.getCredentialIdentifier();

        // Check for at least 8 characters
        if (password.length() < 8) {
            return CredentialValidationResult.failed("Password must be at least 8 characters long");
        }

        // Check for at least one uppercase letter, one lowercase letter and one digit
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasUpperCase && hasLowerCase && hasDigit) {
                break;
            }
        }

        if (!hasUpperCase) {
            return CredentialValidationResult.failed("Password must contain at least one uppercase letter");
        }
        if (!hasLowerCase) {
            return CredentialValidationResult.failed("Password must contain at least one lowercase letter");
        }
        if (!hasDigit) {
            return CredentialValidationResult.failed("Password must contain at least one digit");
        }

        return CredentialValidationResult.success();
    }

    @Override
    public Sphere getSphere() {
        // This validator belongs to the AUTH sphere
        return Sphere.AUTH;
    }
}