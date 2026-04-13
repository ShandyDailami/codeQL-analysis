import java.util.HashMap;
import java.util.Map;

public class java_40072_SessionManager_A07 {
    // Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_40072_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new AuthFailureException();
        }
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}