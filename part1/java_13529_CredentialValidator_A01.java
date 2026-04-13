import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_13529_CredentialValidator_A01 {
    public static boolean validate(String username, String password) {
        // Assume the password is already hashed
        String hashedPassword = hashPassword(password);

        // Now compare the hashed passwords
        return hashedPassword.equals(username);
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}