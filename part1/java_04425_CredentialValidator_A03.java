import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_04425_CredentialValidator_A03 {

    public boolean isPasswordValid(String passwordToCheck, String storedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(storedPassword.getBytes());
            String storedPasswordHash = Base64.getEncoder().encodeToString(hashBytes);

            return passwordToCheck.equals(storedPasswordHash);
        } catch (NoSuchAlgorithmException e) {
            // handle error
            return false;
        }
    }
}