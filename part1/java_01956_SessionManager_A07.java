import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_01956_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private SecureRandom sr;

    public java_01956_SessionManager_A07() {
        sessionMap = new HashMap<>();
        sr = new SecureRandom();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        byte[] randomBytes = new byte[16];
        sr.nextBytes(randomBytes);
        String secureRandomString = Base64.getEncoder().encodeToString(randomBytes);
        return secureRandomString;
    }
}