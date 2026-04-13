import java.util.HashMap;
import java.util.Map;

public class java_03621_SessionManager_A08 {
    private Map<String, String> sessionMap; // store session id and username

    public java_03621_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // helper method to generate session id
    private String generateSessionId() {
        return Long.toString(System.nanoTime(), Character.MAX_RADIX);
    }
}