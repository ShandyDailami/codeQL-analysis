import java.util.HashMap;

public class java_27079_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    // Initialize sessionMap
    public java_27079_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to clear all sessions
    public void clearSessions() {
        sessionMap.clear();
    }
}