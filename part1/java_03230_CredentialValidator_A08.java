import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_03230_CredentialValidator_A08 {
    // Predefined password to compare against
    private final String predefinedPassword;

    public java_03230_CredentialValidator_A08(String predefinedPassword) {
        this.predefinedPassword = predefinedPassword;
    }

    public boolean isValidPassword(String userPassword) {
        try {
            // Create a MessageDigest instance for the MD5 hash
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the hash of the user's password
            byte[] passwordBytes = userPassword.getBytes();
            byte[] hashBytes = md.digest(passwordBytes);

            // Convert the hash bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            String userPasswordHash = sb.toString();

            // Compare the computed hash with the predefined password
            return userPasswordHash.equals(predefinedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available. Cannot validate password.", e);
        }
    }
}