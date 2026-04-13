import java.util.HashMap;
import java.util.Map;

public class java_11766_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11766_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a random session id for the session
    private String generateSessionId() {
        return Long.toString(System.nanoTime(), 36);
    }
}