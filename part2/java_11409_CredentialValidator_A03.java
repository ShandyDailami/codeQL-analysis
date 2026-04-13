import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_11409_CredentialValidator_A03 {
    public static boolean validateCredentials(String username, String password, String storedPassword) {
        // Create a MessageDigest instance for SHA-256
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Convert the password to a hash
            byte[] hash = md.digest(password.getBytes());
            // Compare the hash with the stored hash
            return Base64.getEncoder().encodeToString(hash).equals(storedPassword);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Generate a hashed password
        String password = "password";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            String hashedPassword = Base64.getEncoder().encodeToString(hash);
            System.out.println(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Validate the credentials
        String username = "user";
        String storedPassword = "hashedpassword";
        boolean isValid = validateCredentials(username, password, storedPassword);
        System.out.println("Is valid: " + isValid);
    }
}