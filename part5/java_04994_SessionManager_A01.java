import java.util.HashMap;
import java.util.Map;

public class java_04994_SessionManager_A01 {

    // A simple map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_04994_SessionManager_A01() {
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

    // Method to update a session
    public void updateSession(String sessionId, String newSessionId) {
        sessionMap.replace(sessionId, newSessionId);
    }
}