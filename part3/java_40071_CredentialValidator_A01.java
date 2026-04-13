import java.util.HashSet;
import java.util.Set;

public class java_40071_CredentialValidator_A01 {

    private static final Set<String> VALID_PASSWORD_PREFIXES = new HashSet<String>() {{
        add("password");
        add("secret");
        add("admin");
        add("admin123");
    }};

    public boolean validate(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

        if (VALID_PASSWORD_PREFIXES.contains(password)) {
            return false;
        }

        return isPasswordStrong(password);
    }

    private boolean isPasswordStrong(String password) {
        // Check for minimum length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check for lowercase
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check for digits
        if (!hasDigit(password)) {
            return false;
        }

        // Check for special characters
        if (!hasSpecialChar(password)) {
            return false;
        }

        return true;
    }

    private boolean hasUpperCase(String password) {
        return password.equals(password.toUpperCase());
    }

    private boolean hasLowerCase(String password) {
        return password.equals(password.toLowerCase());
    }

    private boolean hasDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean hasSpecialChar(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }
}