import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_12695_CredentialValidator_A08 {

    // Simple hashing algorithm
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No SHA-256 algorithm available", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    // Check if the given password matches the hashed password
    public static boolean validateCredentials(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }
}