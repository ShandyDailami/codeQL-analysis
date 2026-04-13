import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.util.Base64;

public class java_20682_CredentialValidator_A01 {

    private String storedPasswordHash;

    public java_20682_CredentialValidator_A01(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            this.storedPasswordHash = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("SHA-256 algorithm not available.");
        }
    }

    public boolean isPasswordValid(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            String generatedPasswordHash = Base64.getEncoder().encodeToString(hash);

            return this.storedPasswordHash.equals(generatedPasswordHash);
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("SHA-256 algorithm not available.");
        }
    }
}