import java.util.HashMap;
import java.util.Map;

public class java_06252_SessionManager_A01 {
    // Store sessions
    private Map<String, String> sessionMap;

    public java_06252_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method for creating a new session
    public String createSession(String user) {
        String sessionId = java.util.UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method for accessing a session
    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeException("Invalid session ID");
        }
    }

    // Method for closing a session
    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new RuntimeException("Invalid session ID");
        }
    }
}