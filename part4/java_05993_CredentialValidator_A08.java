// Importing necessary libraries
import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_05993_CredentialValidator_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Test Credentials
        String plaintext = "password123";
        String encodedPassword = encodePassword(plaintext, "SHA-256");

        String testUser = "testUser";
        String testPassword = "testPassword";

        if (validateCredentials(testUser, testPassword, encodedPassword, "SHA-256")) {
            System.out.println("Access Granted");
        } else {
            System.out.println("Access Denied");
        }
    }

    private static String encodePassword(String password, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] passwordInBytes = md.digest(password.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(passwordInBytes);
        return encodedPassword;
    }

    private static boolean validateCredentials(String username, String password, String encryptedPassword, String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == "SHA-256") {
            return encryptedPassword.equals(encodePassword(password, algorithm));
        } else {
            return encryptedPassword.equals(password);
        }
    }
}