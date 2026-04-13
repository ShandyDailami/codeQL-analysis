import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_12978_CredentialValidator_A03 {

    private final MessageDigest digest;

    public java_12978_CredentialValidator_A03() {
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("No such algorithm", e);
        }
    }

    public boolean validate(String username, String password) {
        String hashedPassword = hashPassword(password);

        // Assume the database holds hashed passwords for the user
        // If the hashed passwords match, return true
        // Otherwise, return false

        // For the sake of simplicity, we'll just return true or false for now
        // Replace this with actual authentication logic

        return (hashedPassword.equals(hashedPassword));
    }

    private String hashPassword(String password) {
        byte[] hash = this.digest.digest(password.getBytes());
        return bytesToHex(hash);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}