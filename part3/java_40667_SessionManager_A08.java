import java.util.HashMap;
import java.util.Map;

public class java_40667_SessionManager_A08 {
    // Private map to hold session data
    private Map<String, String> sessionMap;

    // Default constructor
    public java_40667_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    // Method to retrieve session data
    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove session data
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to update session data
    public void updateSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionData);
        } else {
            System.out.println("Session not found");
        }
    }
}