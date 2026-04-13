import java.util.HashMap;
import java.util.Map;

public class java_12123_SessionManager_A08 {
    // Using a HashMap as our session storage
    private Map<String, String> sessionMap;

    // Constructor
    public java_12123_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId of a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}