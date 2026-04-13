import java.security.InvalidParameterException;

public class java_11076_CredentialValidator_A07 {

    public static void validatePassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        if (password.length() < 8) {
            throw new InvalidParameterException("Password must be at least 8 characters long");
        }

        if (password.matches(".*\\d.*")) {
            throw new InvalidParameterException("Password must contain at least one digit");
        }

        if (password.matches(".*[a-z].*")) {
            throw new InvalidParameterException("Password must contain at least one lowercase letter");
        }

        if (password.matches(".*[A-Z].*")) {
            throw new InvalidParameterException("Password must contain at least one uppercase letter");
        }

        if (password.matches(".*[^a-zA-Z0-9].*")) {
            throw new InvalidParameterException("Password must contain at least one special character");
        }
    }
}