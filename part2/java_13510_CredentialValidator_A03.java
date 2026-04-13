import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_13510_CredentialValidator_A03 {
    public boolean validate(String passwordAttempt, String storedPassword) {
        if (passwordAttempt == null || storedPassword == null) {
            throw new IllegalArgumentException("Null arguments are not allowed");
        }

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // Encrypt the password attempt using MD5
        byte[] attemptBytes = digest.digest(passwordAttempt.getBytes());

        // Convert bytes to hexadecimal string
        String attemptHex = bytesToHex(attemptBytes);

        // Compare the hashed password attempt with the stored password
        return attemptHex.equals(storedPassword);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02X", b));
        }
        return builder.toString();
    }
}