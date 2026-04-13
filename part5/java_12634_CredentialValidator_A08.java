import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_12634_CredentialValidator_A08 {
    private static final String SALT = "Salt"; // Salting for security

    public boolean validate(String username, String password) {
        String hashedPassword = hashPassword(password + SALT);

        // Here you can use your actual credentials to check if the hashed password matches.
        // For simplicity, we're only comparing the two strings.
        return hashedPassword.equals(hashedPassword(username));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String hashedPassword(String username) {
        // Here you can retrieve the hashed password from your actual database.
        // For simplicity, we're just returning the hash of the username.
        return hashPassword(username);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}