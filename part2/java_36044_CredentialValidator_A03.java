import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_36044_CredentialValidator_A03 {

    public boolean isValidCredential(String username, String password) {
        // Hash the password using SHA-256
        String hashedPassword = hashPassword(password);

        // Comparing hashed password with stored password
        // For the sake of this example, we'll use a static password here
        if (hashedPassword.equals("5e884098163327c80fb86149808d8488492e8356")) {
            return true;
        } else {
            return false;
        }
    }

    private String hashPassword(String password) {
        try {
            // Get the hash value of the password
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception
            e.printStackTrace();
            return null;
        }
    }
}