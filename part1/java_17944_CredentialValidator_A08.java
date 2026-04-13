import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_17944_CredentialValidator_A08 {
    // Method to calculate the SHA-256 hash of a password
    public String calculateSha256(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException | java.lang.StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to convert byte array to hexadecimal string
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02X", b));
        }
        return builder.toString();
    }

    // Method to validate the password
    public boolean validatePassword(String password, String storedPassword) {
        String hashedPassword = calculateSha256(password);
        return hashedPassword.equals(storedPassword);
    }
}