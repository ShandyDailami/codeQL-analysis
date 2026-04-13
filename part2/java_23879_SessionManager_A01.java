import java.util.HashMap;
import java.util.Map;

public class java_23879_SessionManager_A01 {
    // Use a HashMap for storing sessions
    private Map<String, String> sessionMap;

    public java_23879_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = "SESSION-" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to check if the session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the userId of the session
    public String getUserId(String sessionId) {
        if (isValidSession(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session");
        }
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}