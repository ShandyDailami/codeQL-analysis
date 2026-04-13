import java.util.HashMap;
import java.util.Map;

public class java_35465_SessionManager_A03 {
    // Session data will be stored in a map
    private Map<String, String> sessionData;

    // Constructor
    public java_35465_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId, String userId) {
        sessionData.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the user from a session
    public String getUserFromSession(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}