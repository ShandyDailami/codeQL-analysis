import java.util.HashMap;
import java.util.Map;

public class java_07350_SessionManager_A07 {
    // The underlying data structure for storing sessions
    private Map<String, String> sessionMap;

    // Default constructor
    public java_07350_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId for a given session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}