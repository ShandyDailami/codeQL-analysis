import java.util.HashMap;

public class java_00348_SessionManager_A03 {

    // Define a new HashMap to hold session data
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_00348_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get the session data
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

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}