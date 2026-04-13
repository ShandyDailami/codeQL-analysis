import java.util.HashMap;
import java.util.Map;

public class java_07935_SessionManager_A03 {
    // Map to store sessions
    private Map<String, String> sessionMap;

    // Default constructor
    public java_07935_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to get the user name for a given session
    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate if a session exists
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}