import java.util.HashMap;
import java.util.Map;

public class java_05414_SessionManager_A01 {
    // Define a HashMap to store session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_05414_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    // Method to get session data
    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}