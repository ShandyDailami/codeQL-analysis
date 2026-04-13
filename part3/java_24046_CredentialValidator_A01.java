import javax.security.auth.CredentialValidationResult;
import javax.security.auth.UsernamePasswordCredentials;
import javax.security.auth.login.CredentialException;

public class java_24046_CredentialValidator_A01 implements javax.security.auth.CredentialValidator {

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredentials credentials) throws CredentialException {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // Check if the password is too short
        if (password.length() < 8) {
            return CredentialValidationResult.failed("Password is too short.");
        }

        // Check if the password contains a uppercase letter
        if (!hasUpperCase(password)) {
            return CredentialValidationResult.failed("Password should contain an uppercase letter.");
        }

        // Check if the password contains a lowercase letter
        if (!hasLowerCase(password)) {
            return CredentialValidationResult.failed("Password should contain a lowercase letter.");
        }

        // Check if the password contains a number
        if (!hasNumber(password)) {
            return CredentialValidationResult.failed("Password should contain a number.");
        }

        // If the password passes all checks, return success
        return CredentialValidationResult.success();
    }

    // Helper method to check if a string contains an uppercase letter
    private boolean hasUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if a string contains a lowercase letter
    private boolean hasLowerCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if a string contains a number
    private boolean hasNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}