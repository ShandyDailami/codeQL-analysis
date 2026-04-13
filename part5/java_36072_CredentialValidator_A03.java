import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_36072_CredentialValidator_A03 {
    // User object
    private User user;

    // Constructor
    public java_36072_CredentialValidator_A03(User user) {
        this.user = user;
    }

    // Method to validate the password
    public boolean validatePassword(String password) {
        try {
            // Create a MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the hash of the password
            byte[] hash = md.digest(password.getBytes());

            // Compare the hash of the user's password with the hash of the provided password
            return user.getPassword().equals(bytesToHex(hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        // If an error occurs, return false
        }
        return false;
    }

    // Method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}