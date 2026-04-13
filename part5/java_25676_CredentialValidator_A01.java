import java.security.InvalidParameterException;

public class java_25676_CredentialValidator_A01 {

    // Simple validation of password strength
    public static boolean isValidPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password is null");
        }
        
        // Legacy rules: password must be at least 8 characters long and contain at least one digit, one uppercase and one lowercase letter.
        if (password.length() < 8 || !password.matches(".*\\d.*") || !password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*")) {
            return false;
        }

        return true;
    }
}