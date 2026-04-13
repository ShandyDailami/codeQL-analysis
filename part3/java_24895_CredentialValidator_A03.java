import java.security.InvalidParameterException;

public class java_24895_CredentialValidator_A03 {
    // This method will check if a password is strong enough
    // A strong password should have at least 8 characters, at least one uppercase letter,
    // at least one lowercase letter, and at least one digit.
    public boolean isPasswordStrongEnough(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

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
                return true;
            }
        }

        return false;
    }

    // This method will validate a user's credentials
    public boolean validateCredentials(String username, String password) {
        if (!isPasswordStrongEnough(password)) {
            throw new InvalidParameterException("Password is not strong enough");
        }

        // Here you can put any operations related to user authentication.
        // For example, you can call a method in a database to verify the user's credentials.

        return true;
    }
}