public interface CredentialValidator {
    // Validate the password against the given policy.
    boolean validate(String password);
}

public class java_22986_CredentialValidator_A08 implements CredentialValidator {
    // The following variables store the necessary conditions for a password to be valid.
    private int minLength = 8;
    private boolean hasNumber = false;
    private boolean hasUpperCase = false;
    private boolean hasLowerCase = false;
    private boolean hasSpecialChars = false;

    @Override
    public boolean validate(String password) {
        // Check if password is too short.
        if (password.length() < minLength) {
            return false;
        }

        // Check if password contains at least one number.
        if (!hasNumber && password.matches(".*[0-9].*")) {
            hasNumber = true;
        }

        // Check if password contains at least one uppercase letter.
        if (!hasUpperCase && password.matches(".*[A-Z].*")) {
            hasUpperCase = true;
        }

        // Check if password contains at least one lowercase letter.
        if (!hasLowerCase && password.matches(".*[a-z].*")) {
            hasLowerCase = true;
       
        }

        // Check if password contains at least one special character.
        if (!hasSpecialChars && password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            hasSpecialChars = true;
        }

        // If all the conditions are met, return true.
        return (hasNumber && hasUpperCase && hasLowerCase && hasSpecialChars);
    }
}