import java.util.HashMap;

public class java_14491_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_14491_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a real-world implementation.
        // It would generate a unique session ID using a UUID or a similar method.
        return "session123";
    }
}