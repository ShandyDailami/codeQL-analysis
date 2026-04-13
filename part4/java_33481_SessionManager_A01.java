import java.util.HashMap;
import java.util.Map;

public class java_33481_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33481_SessionManager_A01() {
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

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a random session id
    private String generateSessionId() {
        // This is a simple example, in a real application, you would likely generate
        // a UUID (Universally Unique Identifier) instead of a random session id.
        return String.valueOf(System.currentTimeMillis());
    }
}