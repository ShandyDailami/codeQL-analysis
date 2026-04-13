// START: CredentialValidator.java
import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_12097_CredentialValidator_A07 {
    public boolean validate(String username, String password, String dbPassword) {
        try {
            // Step 1: Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Step 2: Hash the password the same way we did in the database
            byte[] hash = digest.digest(password.getBytes("UTF-8"));

            // Step 3: Convert the hash bytes to a hexadecimal string
            String passwordHash = Base64.getEncoder().encodeToString(hash);

            // Step 4: Compare the hash of the password provided by the user to the hash of the password in the database
            return passwordHash.equals(dbPassword);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
// END: CredentialValidator.java