import java.util.HashMap;
import java.util.Map;

public class java_06341_SessionManager_A07 {
    // Define the session map
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_06341_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }
}