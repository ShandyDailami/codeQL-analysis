import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_22910_CredentialValidator_A08 {
    private static final String HASH_ALGORITHM = "SHA-256";

    private String passwordHash;

    public java_22910_CredentialValidator_A08(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] hash = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        this.passwordHash = Base64.getEncoder().encodeToString(hash);
    }

    public boolean validatePassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] hash = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        return this.passwordHash.equals(Base64.getEncoder().encodeToString(hash));
    }
}