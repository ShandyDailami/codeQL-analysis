import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_29688_CredentialValidator_A03 {
    public boolean isValidPassword(String password, String hashedPassword) {
        try {
            // Create a MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the hash of the password and compare it to the hashedPassword
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            String hashedPasswordInString = sb.toString();

            // Check if the hashedPassword and the password matches
            return hashedPasswordInString.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            // Handle exception here
            e.printStackTrace();
            return false;
        }
    }
}