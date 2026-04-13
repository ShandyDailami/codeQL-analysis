import java.util.HashMap;
import java.util.Map;

public class java_30616_SessionManager_A01 {
    // Use a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Default constructor
    public java_30616_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Example of a secure operation: check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}