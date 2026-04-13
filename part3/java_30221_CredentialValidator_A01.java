import java.util.List;

public class java_30221_CredentialValidator_A01 {
    // Predefined list of rules for password strength
    private static final List<String> STRONG_PASSWORD_RULES = List.of(
            "password",
            "123456",
            "admin",
            "root",
            "qwerty",
            "admin123",
            "1234567",
            "password123",
            "111111",
            "123456789",
            "12345678",
            "12345",
            "123",
            "1234567890",
            "1234",
            "123456",
            "11111",
            "1111",
            "111",
            "1234567890123456",
            "1234567",
            "12345",
            "123",
            "1234",
            "12345",
            "123456789012",
            "1234567890",
            "12345678",
            "123456",
            "1234",
            "123",
            "12345678",
            "1234567890",
            "123456789",
            "11111111",
            "1234567",
            "12345",
            "123",
            "1234",
            "12345678",
            "123456",
            "123",
            "12345",
            "12345",
            "123456",
            "12345678",
            "123456789",
            "1111111",
            "1234567890",
            "123456789",
            "12345678",
            "123456",
            "1234",
            "123",
            "1234567890",
            "12345678",
            "12345",
            "123",
            "12345",
            "123456",
            "12345678",
            "1234567890",
            "11111111",
            "1234567890",
            "123456789",
            "12345678",
            "123456",
            "1234",
            "123",
            "1234567890",
            "12345678",
            "12345",
            "123",
            "12345",
            "123456",
            "12345678",
            "123456789",
            "1111111",
            "1234567890",
            "123456789",
            "12345678",
            "123456",
            "1234",
            "123",
            "1234567890",
            "12345678",
            "12345",
            "123",
            "12345",
            "123456",
            "12345678",
            "123456789",
            "1111111"
    );

    public boolean validatePassword(String password) {
        // Check the password against the list of strong rules
        if (STRONG_PASSWORD_RULES.contains(password)) {
            return false; // The password is too strong, not allowed
        }

        // Check the password against other rules
        if (password.length() < 8) {
            return false; // The password must be at least 8 characters long
        }

        if (!hasUpperCase(password)) {
            return false; // The password must contain at least one upper case letter
        }

        if (!hasLowerCase(password)) {
            return false; // The password must contain at least one lower case letter
        }

        if (!hasDigit(password)) {
            return false; // The password must contain at least one digit
        }

        if (!hasSpecialChar(password)) {
            return false; // The password must contain at least one special character
        }

        // If all checks passed, the password is valid
        return true;
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean hasSpecialChar(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }
}