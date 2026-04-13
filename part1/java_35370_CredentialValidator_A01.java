import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_35370_CredentialValidator_A01 {

    private MessageDigest messageDigest;

    public java_35370_CredentialValidator_A01() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validate(String plainText, String hashedText) {
        return hashedText.equals(this.hash(plainText));
    }

    private String hash(String input) {
        byte[] hash = messageDigest.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}