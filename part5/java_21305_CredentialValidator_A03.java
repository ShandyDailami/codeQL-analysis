import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_21305_CredentialValidator_A03 {

    private static final String HASH_ALGORITHM = "SHA-256";

    public boolean isValidPassword(String password, String hashedPassword) {
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] hashedPasswordBytes = Base64.getDecoder().decode(hashedPassword);

        MessageDigest digest = getMessageDigest();
        byte[] hashedInputBytes = digest.digest(passwordBytes);

        return MessageDigest.isEqual(hashedInputBytes, hashedPasswordBytes);
    }

    private MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available", e);
        }
    }
}