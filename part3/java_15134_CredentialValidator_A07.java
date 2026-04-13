import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_15134_CredentialValidator_A07 {

    // This is a placeholder for a secure hashing algorithm
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validateCredentials(String enteredPassword, String hashedPassword) {
        return hashPassword(enteredPassword).equals(hashedPassword);
    }

    public static void main(String[] args) {
        String password = "myPassword";
        String hashedPassword = hashPassword(password);

        if (validateCredentials(password, hashedPassword)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}