import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_29768_CredentialValidator_A03 {

    public boolean validatePassword(String plainPassword, String hashedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(plainPassword.getBytes());
            String hashedPasswordString = Base64.getEncoder().encodeToString(hashedBytes);

            return hashedPasswordString.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception here
            throw new RuntimeException(e);
        }
    }
}