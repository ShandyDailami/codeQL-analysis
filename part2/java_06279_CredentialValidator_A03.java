import java.security.InvalidParameterException;
import java.util.Base64;

public class java_06279_CredentialValidator_A03 {
    private static final String SALT = "SALT"; // SALT is a string that is appended to the user's password before hashing. It's used to prevent rainbow table attacks.

    // The user's password is passed as a string.
    // Returns the hashed password.
    public String hashPassword(String password) {
        // Ensure the password is not null or empty.
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }

        // Append the SALT to the password.
        String hashedPassword = password + SALT;

        // Hash the password using a hashing function.
        // In this case, we're using SHA-256.
        hashedPassword = hash(hashedPassword, "SHA-256");

        return hashedPassword;
    }

    // The user's password and hashed password are passed as strings.
    // Returns true if the password matches the hashed password, false otherwise.
    public boolean verifyPassword(String password, String hashedPassword) {
        // Ensure the password and hashed password are not null or empty.
        if (password == null || password.isEmpty() || hashedPassword == null || hashedPassword.isEmpty()) {
            throw new InvalidParameterException("Password and hashed password cannot be null or empty");
        }

        // Verify the password by comparing it to the hashed password.
        String hashedVerification = hash(password + SALT, "SHA-256");
        return hashedVerification.equals(hashedPassword);
    }

    // The string to be hashed and the algorithm to use are passed as strings.
    // Returns the hashed string.
    private String hash(String input, String algorithm) {
        // Implement the hashing algorithm.
        // This is a simplification. In a real application, you would use a library like Bouncy Castle.
        // You would also use a salt to prevent rainbow table attacks.
        switch (algorithm) {
            case "SHA-256":
                return hashSHA256(input);
            default:
                throw new UnsupportedOperationException("Unsupported algorithm: " + algorithm);
        }
    }

    // The string to be hashed is passed as a string.
    // Returns the hashed string.
    private String hashSHA256(String input) {
        // Use the SHA-256 algorithm to hash the input.
        // In a real application, you would use a library like Bouncy Castle.
        byte[] hash = getSHA256Digest().digest(input.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // Returns a hashed password.
    public String generateHashedPassword() {
        // Generate a random password.
        String password = "password"; // Replace with your own password generation logic.
        return hashPassword(password);
    }
}