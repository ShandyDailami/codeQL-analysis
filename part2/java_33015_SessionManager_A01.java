import java.util.HashMap;
import java.util.Map;

public class java_33015_SessionManager_A01 {
    // Create a map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_33015_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the userId associated with a session
    public String getUserId(String sessionId) {
        if (isValidSession(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    // Example of a security-sensitive operation related to A01_BrokenAccessControl
    public void accessSystem(String sessionId) {
        if (isValidSession(sessionId)) {
            String userId = getUserId(sessionId);
            // Access system with userId
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }
}