import java.util.HashMap;
import java.util.Map;

public class java_41225_SessionManager_A07 {
    // User -> SessionID mapping
    private Map<String, String> sessionMap;

    public java_41225_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session for a user
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    // Method to validate the session
    public boolean validateSession(String userId, String sessionId) {
        return sessionMap.get(userId).equals(sessionId);
    }
}