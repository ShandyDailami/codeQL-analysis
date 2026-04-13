import java.util.HashMap;
import java.util.Map;

public class java_34025_SessionManager_A08 {
    // A map to hold the sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_34025_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to add a new session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get the userId of a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }
}