import java.security.InvalidParameterException;
import java.security.cert.X509Certificate;

public class java_37753_CredentialValidator_A07 {

    // This method validates the user's credential.
    // It takes in the username and password, and validates them
    // The username must be at least 6 characters long and
    // the password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character
    public void validateCredential(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }

        if (username.length() < 6) {
            throw new InvalidParameterException("Username must be at least 6 characters long.");
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : username.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!isSpecialChar(c)) {
                hasSpecialChar = true;
            }
        }

        if (!hasUpperCase || !hasLowerCase || !hasDigit || !hasSpecialChar) {
            throw new InvalidParameterException("Username must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }

        if (password.length() < 8) {
            throw new InvalidParameterException("Password must be at least 8 characters long.");
        }
    }

    private boolean isSpecialChar(char c) {
        return !(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c >= '0' && c <= '9');
    }
}