import java.util.HashMap;
import java.util.Map;

public class java_03051_SessionManager_A03 {
    private Map<String, String> sessionMap;

    // Constructor
    public java_03051_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to clear all sessions
    public void clearSessions() {
        sessionMap.clear();
    }

    // Method to check if a session exists
    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Session Manager Class ends here
}