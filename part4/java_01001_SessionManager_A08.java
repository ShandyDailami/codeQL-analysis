import java.util.HashMap;
import java.util.Map;

public class java_01001_SessionManager_A08 {

    // Create a new HashMap to hold sessions
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_01001_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get the session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to update a session
    public void updateSession(String sessionId, String newSessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionId);
        }
    }

    // Method to check if a session exists
    public boolean containsSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}