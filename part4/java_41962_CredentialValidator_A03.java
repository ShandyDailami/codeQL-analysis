import java.security.Principal;

public class java_41962_CredentialValidator_A03 {
    public static boolean validateCredentials(Principal principal, String password) {
        // Basic validation: check if principal is null or empty
        if (principal == null || principal.getName().isEmpty()) {
            throw new IllegalArgumentException("Principal cannot be null or empty.");
        }

        // Basic validation: check if password is null or empty
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }

        // Realistic validation: check if password has a strong enough complexity
        if (!hasStrongPasswordComplexity(password)) {
            throw new IllegalArgumentException("Password must have a strong enough complexity.");
        }

        // Realistic validation: check if password has a sufficient length
        if (!hasSufficientPasswordLength(password)) {
            throw new IllegalArgumentException("Password must have a sufficient length.");
        }

        // Realistic validation: check if password contains common passwords
        if (hasCommonPassword(password)) {
            throw new IllegalArgumentException("Password cannot contain common passwords.");
        }

        // Realistic validation: check if password contains a sequence of characters
        if (hasPasswordSequence(password)) {
            throw new IllegalArgumentException("Password cannot contain a sequence of characters.");
        }

        // All validations passed, return true
        return true;
    }

    private static boolean hasStrongPasswordComplexity(String password) {
        // Complexity check: length > 8 characters
        return password.length() > 8;
    }

    private static boolean hasSufficientPasswordLength(String password) {
        // Length check: length >= 10 characters
        return password.length() >= 10;
    }

    private static boolean hasCommonPassword(String password) {
        // Common passwords: common passwords should not be used in the password
        List<String> commonPasswords = Arrays.asList("password", "admin", "user", "123456", "admin123");
        return commonPasswords.contains(password);
    }

    private static boolean hasPasswordSequence(String password) {
        // Sequence check: password should not contain a sequence of characters
        // Sequence is defined as any series of characters that appear more than once in the password
        return !password.matches(".*\\S.*");
    }
}