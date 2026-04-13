import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordValidator;
import javax.security.auth.login.CredentialException;

public class java_38882_CredentialValidator_A01 implements PasswordValidator {

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) throws CredentialException {
        String password = credential.getCredential();

        // check password length
        if (password.length() < 8) {
            return CredentialValidationResult.failed("Password length must be at least 8 characters");
        }

        // check for uppercase letter
        if (!hasUpperCase(password)) {
            return CredentialValidationResult.failed("Password must contain at least one uppercase letter");
        }

        // check for lowercase letter
        if (!hasLowerCase(password)) {
            return CredentialValidationResult.failed("Password must contain at least one lowercase letter");
        }

        // check for number
        if (!hasNumber(password)) {
            return CredentialValidationResult.failed("Password must contain at least one number");
        }

        // check for special character
        if (!hasSpecialChar(password)) {
            return CredentialValidationResult.failed("Password must contain at least one special character");
        }

        // if all conditions are satisfied, return success
        return CredentialValidationResult.success();
    }

    private boolean hasUpperCase(String word) {
        // Returns true if there is at least one uppercase letter in the string.
        // Otherwise, it returns false.
        return word.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String word) {
        // Returns true if there is at least one lowercase letter in the string.
        // Otherwise, it returns false.
        return word.matches(".*[a-z].*");
    }

    private boolean hasNumber(String word) {
        // Returns true if there is at least one number in the string.
        // Otherwise, it returns false.
        return word.matches(".*[0-9].*");
    }

    private boolean hasSpecialChar(String word) {
        // Returns true if there is at least one special character in the string.
        // Otherwise, it returns false.
        return word.matches(".*[~!@#$%^&*()_=-].*");
    }
}