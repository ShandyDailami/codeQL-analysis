import java.security.GeneralSecurityException;
import java.security.SecureRandom;

public class java_16197_CredentialValidator_A08 {

    // Secure random generator for password
    private final SecureRandom random = new SecureRandom();

    // Function to check if a password is valid
    public boolean isValidPassword(String password) throws GeneralSecurityException {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            throw new GeneralSecurityException("Password cannot be null or empty.");
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            throw new GeneralSecurityException("Password must be at least 8 characters long.");
        }

        // Check if password contains a special character
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            throw new GeneralSecurityException("Password must contain at least one special character.");
        }

        // If password passes all checks, return true
        return true;
    }

    // Function to generate a random password
    public String generatePassword() {
        // Generate a random password of 12 characters long
        StringBuilder password = new StringBuilder(12);
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(25); // 0-24
            password.append((char) (index + 'a')); // Get a character at the random index
        }
        return password.toString();
    }
}