import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_34485_SessionManager_A03 {

    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getUrlEncoder();

    private Map<String, String> sessionMap;

    public java_34485_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = createRandomSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String createRandomSessionId() {
        byte[] randomBytes = new byte[24];
        random.nextBytes(randomBytes);
        return encoder.encodeToString(randomBytes);
    }
}