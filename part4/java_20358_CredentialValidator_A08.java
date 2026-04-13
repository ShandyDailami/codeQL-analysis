import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_20358_CredentialValidator_A08 {

    public static void main(String[] args) {
        String passwordToCheck = "password123";
        String storedPassword = "123";

        // Store the password in a secure way (in this case, a hash)
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(storedPassword.getBytes());
            String securePassword = Base64.getEncoder().encodeToString(hash);

            // Check the password
            if (isPasswordSecure(passwordToCheck, securePassword)) {
                System.out.println("Password is secure!");
            } else {
                System.out.println("Password is not secure!");
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-256 algorithm not supported.");
        }
    }

    private static boolean isPasswordSecure(String passwordToCheck, String securePassword) {
        // This method verifies the user's password against the stored hash.
        // This is a very simple example and lacks many real-world security features.
        return securePassword.equals(hashPassword(passwordToCheck));
    }

    private static String hashPassword(String passwordToHash) {
        // This method hashes the user's password using SHA-256.
        // This is a very simple example and lacks many real-world security features.
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(passwordToHash.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-256 algorithm not supported.");
            return null;
        }
    }
}