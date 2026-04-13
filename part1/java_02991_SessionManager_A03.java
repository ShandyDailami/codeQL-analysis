import java.util.HashMap;
import java.util.Map;

public class java_02991_SessionManager_A03 {

    // Using a HashMap as a SessionStorage
    private Map<String, String> sessionMap;

    // SessionManager constructor
    public java_02991_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String userName) {
        // Generate a unique sessionId
        String sessionId = UUID.randomUUID().toString();
        // Store userName and sessionId in sessionMap
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to get userName from a session
    public String getUserName(String sessionId) {
        // Check if sessionId exists in sessionMap
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalStateException("Session not found");
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session from sessionMap
        sessionMap.remove(sessionId);
    }
}