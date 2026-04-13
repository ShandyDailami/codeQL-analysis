import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_15327_SessionManager_A08 {
    private static final String ALGORITHM = "SHA-256";
    private static final int KEY_LENGTH = 16;

    private SecureRandom random = new SecureRandom();
    private MessageDigest digest = getDigest(ALGORITHM);

    public String generateSessionId() {
        byte[] bytes = new byte[KEY_LENGTH];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().encodeToString(bytes);
    }

    public String encrypt(String data) {
        byte[] bytes = data.getBytes();
        byte[] hash = digest.digest(bytes);
        return Base64.getUrlEncoder().encodeToString(hash);
    }

    private MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Unsupported algorithm: " + algorithm, e);
        }
    }
}