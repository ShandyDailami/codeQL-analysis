import java.security.SecureRandom;
import java.util.Base64;

public class java_27934_SessionManager_A08 {
    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getEncoder();

    public static void main(String[] args) {
        String sessionId = createSessionId();
        String sessionKey = createSessionKey();
        System.out.println("Created session with ID: " + sessionId + " and Key: " + sessionKey);
    }

    private static String createSessionId() {
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        return encoder.encodeToString(randomBytes);
    }

    private static String createSessionKey() {
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        return encoder.encodeToString(randomBytes);
    }
}