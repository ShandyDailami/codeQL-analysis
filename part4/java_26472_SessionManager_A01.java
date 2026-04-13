import java.util.HashMap;
import java.util.Map;

public class java_26472_SessionManager_A01 {
    // A HashMap to store session data.
    private Map<String, String> sessionMap;

    public java_26472_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session.
    public boolean validateSession(String sessionId, String expectedUserId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId).equals(expectedUserId);
        }
        return false;
    }

    // Method to end a session.
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}