import java.util.HashMap;
import java.util.Map;

public class java_37460_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_37460_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple example, but in a real application, you should use a more complex method
        // that generates a unique ID based on a secure random source.
        return String.valueOf(System.nanoTime());
    }
}