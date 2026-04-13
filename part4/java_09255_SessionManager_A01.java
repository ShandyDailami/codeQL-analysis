// import necessary libraries
import java.util.HashMap;
import java.util.Map;

public class java_09255_SessionManager_A01 {
    // Create a HashMap to hold sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_09255_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}