import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_05117_CredentialValidator_A07 {
    public boolean validate(String plainText, String hashedText) {
        try {
            String hashed = hash(plainText);
            return hashed.equals(hashedText);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No supported algorithm.", e);
        }
    }

    private String hash(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hash);
    }
}