import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_15179_SessionManager_A08 {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*()_+=-=[]\\\";:{},.<>?/";
    private static final int SECURE_RANDOM_LENGTH = 32;

    private SecureRandom random = new SecureRandom();
    private MessageDigest digest;

    public java_15179_SessionManager_A08() {
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String createSessionId() {
        return createSessionId(randomSessionId());
    }

    public String createSessionId(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            return createSessionId(randomSessionId());
        }
        digest.update(sessionId.getBytes());
        byte[] bytes = digest.digest();
        return Base64.getEncoder().encodeToString(bytes);
    }

    private String randomSessionId() {
        byte[] randomBytes = new byte[SECURE_RANDOM_LENGTH];
        random.nextBytes(randomBytes);
        return new String(randomBytes, 0, randomBytes.length, "UTF-8");
    }
}