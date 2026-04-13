import java.util.HashMap;
import java.util.Map;

public class java_18392_SessionManager_A07 {

    // Create a new instance of the map
    private Map<String, String> sessionMap = new HashMap<>();

    // Method to create a session
    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    // Method to retrieve session data
    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to update the session data
    public void updateSessionData(String sessionId, String newData) {
        sessionMap.put(sessionId, newData);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get all session IDs
    public Map<String, String> getAllSessions() {
        return sessionMap;
    }
}