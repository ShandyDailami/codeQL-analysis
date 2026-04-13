import java.lang.security.SecureRandom;
import java.util.Base64;

public class java_16239_SessionManager_A08 {
    private static final SecureRandom random = new SecureRandom();

    public String encryptSessionId(String sessionId) {
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        String randomString = new String(randomBytes, "UTF-8");
        String encryptedSessionId = Base64.getEncoder().encodeToString(randomString.getBytes());
        return encryptedSessionId;
    }

    public String decryptSessionId(String encryptedSessionId) {
        byte[] randomBytes = Base64.getDecoder().decode(encryptedSessionId);
        String randomString = new String(randomBytes, "UTF-8");
        return randomString;
    }
}