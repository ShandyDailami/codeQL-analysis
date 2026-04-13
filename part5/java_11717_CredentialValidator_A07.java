import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_11717_CredentialValidator_A07 {
    public boolean isValidCredential(String username, String password, String hashedPassword) {
        try {
            // Hashing the user password
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            String hashedPasswordDB = Base64.getEncoder().encodeToString(hash);

            // Checking if the hashed password matches the hashed password in the database
            return hashedPasswordDB.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}