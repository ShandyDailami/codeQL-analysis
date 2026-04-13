import java.util.HashMap;

public class java_08077_SessionManager_A01 {
    // Define a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Initialize the session map
    public java_08077_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return "Session created with ID: " + sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
        return "Session with ID: " + sessionId + " deleted.";
    }

    // Method to clear all sessions
    public void clearSessions() {
        sessionMap.clear();
    }
}