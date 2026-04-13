import java.util.HashMap;
import java.util.Map;

public class java_36010_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_36010_SessionManager_A07() {
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

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a session id generator, you should replace this with a secure one.
        return "A07_AuthFailure_" + System.nanoTime();
    }
}