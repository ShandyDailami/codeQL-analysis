import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_26145_CredentialValidator_A03 {
    // We'll use SHA-256 for hashing the password
    private MessageDigest messageDigest;

    public java_26145_CredentialValidator_A03() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to hash the password
    private String hashPassword(String password) {
        byte[] hash = messageDigest.digest(password.getBytes());
        return bytesToHex(hash);
    }

    // Method to convert bytes to hexadecimal
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    // Method to verify the password
    public boolean validatePassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }
}