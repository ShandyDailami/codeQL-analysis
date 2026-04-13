import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_27438_CredentialValidator_A08 {
    // Method to generate a hash of a password
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // Method to validate a password
    public static boolean validatePassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
        // Compare the hashed password to the given password
        return hashPassword(password).equals(hashedPassword);
    }

    // Main method for testing
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password";
        String hashedPassword;

        // Hash the password
        hashedPassword = hashPassword(password);

        // Validate the password
        boolean isValid = validatePassword(password, hashedPassword);

        // Print the result
        System.out.println("Is password valid? " + isValid);
    }
}