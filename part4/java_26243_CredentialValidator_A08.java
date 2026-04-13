import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_26243_CredentialValidator_A08 {

    private MessageDigest messageDigest;

    public java_26243_CredentialValidator_A08() {
        try {
            this.messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("No suitable algorithm found for hashing");
        }
    }

    public String hashPassword(String password) {
        byte[] hashBytes = this.messageDigest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public boolean validatePassword(String password, String hashedPassword) {
        return this.hashPassword(password).equals(hashedPassword);
    }
}