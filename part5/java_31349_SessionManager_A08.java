import java.util.HashMap;
import java.util.Map;

public class java_31349_SessionManager_A08 {
    // Create a private HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_31349_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to validate the session
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to close the session
    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}