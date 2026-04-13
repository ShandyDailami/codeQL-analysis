import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.Credential;

public class java_08141_CredentialValidator_A08 {

    public CredentialValidationResult validate(Credential credential) throws LoginException {
        String password = credential.getCredentialIdentifier();

        // Check for length
        if (password.length() < 8) {
            return CredentialValidationResult.failed("Password must be at least 8 characters long");
        }

        // Check for digits
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            return CredentialValidationResult.failed("Password must contain at least one digit");
        }

        // Check for uppercase letters
        boolean hasUpperCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
                break;
            }
        }
        if (!hasUpperCase) {
            return CredentialValidationResult.failed("Password must contain at least one uppercase letter");
        }

        // Check for special characters
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                hasSpecialChar = true;
                break;
            }
        }
        if (!hasSpecialChar) {
            return CredentialValidationResult.failed("Password must contain at least one special character");
        }

        // If all checks pass, return success
        return CredentialValidationResult.success();
    }
}