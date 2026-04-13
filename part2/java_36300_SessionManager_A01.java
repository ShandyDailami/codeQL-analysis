import java.util.HashMap;
import java.util.Map;

public class java_36300_SessionManager_A01 {

    // Private field for storing sessions
    private Map<String, String> sessionMap;

    // Default constructor
    public java_36300_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method for creating a session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method for retrieving a userId from a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method for deleting a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method for validating a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}