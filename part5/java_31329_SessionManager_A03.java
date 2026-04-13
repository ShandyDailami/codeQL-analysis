import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_31329_SessionManager_A03 {
    private final SecureRandom secureRandom = new SecureRandom();
    private final MessageDigest messageDigest;
    private final Base64.Encoder base64Encoder = Base64.getEncoder();

    public java_31329_SessionManager_A03() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String createSessionId() {
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);
        messageDigest.update(randomBytes);
        return base64Encoder.encodeToString(messageDigest.digest());
    }
}