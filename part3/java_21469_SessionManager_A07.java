import java.util.HashMap;
import java.util.Map;

public class java_21469_SessionManager_A07 {

    // Map to hold all sessions
    private Map<String, String> sessionMap;

    public java_21469_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}