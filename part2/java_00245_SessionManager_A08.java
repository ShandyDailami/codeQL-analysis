import java.util.HashMap;
import java.util.Map;

public class java_00245_SessionManager_A08 {
    // private Map to store session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_00245_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to get a session
    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}