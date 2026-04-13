import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_26739_CredentialValidator_A01 {
    public static void main(String[] args) {
        String password = "password";
        String hashedPassword = hashPassword(password);
        
        // Example of a user providing a password
        String providedPassword = "providedPassword";
        
        if (validatePassword(hashedPassword, providedPassword)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }

    // Method to hash the password
    private static String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to validate the hashed password with the provided password
    private static boolean validatePassword(String hashedPassword, String providedPassword) {
        return hashedPassword.equals(hashPassword(providedPassword));
    }
}