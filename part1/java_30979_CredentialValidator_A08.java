import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.PasswordChangeRequiredException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_30979_CredentialValidator_A08 {

    public CredentialValidationResult validate(String username, String password) throws CredentialNotFoundException, LoginException, PasswordChangeRequiredException {
        // Check password length
        if (password.length() < 8) {
            return CredentialValidationResult.failed("Password must be at least 8 characters long.");
        }

        // Check for special characters
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return CredentialValidationResult.failed("Password must contain at least one special character.");
        }

        // Check for uppercase letters
        if (!password.matches(".*[A-Z].*")) {
            return CredentialValidationResult.failed("Password must contain at least one uppercase letter.");
        }

        // Check for digits
        if (!password.matches(".*[0-9].*")) {
            return CredentialValidationResult.failed("Password must contain at least one digit.");
        }

        // If all checks pass, return successful validation
        return CredentialValidationResult.success("Successfully validated credentials.");
    }
}