import java.util.HashMap;
import java.util.Map;

public class java_07506_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_07506_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the user id for a given session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a session id
    private String generateSessionId() {
        return Long.toString(System.currentTimeMillis());
    }
}